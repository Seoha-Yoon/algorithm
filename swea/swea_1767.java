package DAY7;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

// 전선 설치 - 재귀 - 전선 해체
// DFS와 백트레킹 사용하기
// https://so-cute-danu-dev.tistory.com/9 참고
public class Prob19 {
    static class Core{
        int x, y;
        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Core> cores;
    static int N, maxCore, minLen;
    static int[][] processor;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY7/input19.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            processor = new int[N][N];
            cores = new ArrayList<>();

            // map initialize 및 코어 정보 저장
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    int c = sc.nextInt();
                    processor[i][j] = c;
                    // 코어만 리스트에 저장
                    if(c==1){
                        // 가장자리에 있는 코어라면 skip
                        if(i==0||i==N-1||j==0||j==N-1) continue;
                        cores.add(new Core(i, j));
                    }
                }
            }

            maxCore = Integer.MIN_VALUE;
            minLen = Integer.MAX_VALUE;

            connect(0,0,0);

            System.out.println("#"+test_case+" "+minLen);
        }
    }

    /*
        연결 DFS
        1) 해당 코어의 위치에서 사방 탐색
        2) 한 방향으로 계속해서 나아갔을 때, 범위를 벗어나면 전선 설치
        3) 가는 도중에 코어나 전선을 만난다면 방향을 바꿔서 다시
        4) 설치 성공 -> 정보 누적 후 다음 DFS
        5) 설치 실패 -> 인덱스만 늘려서 DFS
     */
    private static void connect(int idx, int coreCnt, int wireLen) {
        // return 조건, idx가 cores의 사이즈를 벗어났을 때,
        if(idx == cores.size()){
            // 연결한 코어의 수가 더 많으면 minLen, maxCore 업데이트
            if(maxCore < coreCnt){
                maxCore = coreCnt;
                minLen = wireLen;
            }else if(maxCore == coreCnt){
                minLen = Math.min(wireLen, minLen);
            }
            return;
        }

        // 해당 인덱스 위치의 코어의 좌표
        int x = cores.get(idx).x;
        int y = cores.get(idx).y;

        // 상하좌우 탐색
        for(int d = 0 ; d<4; d++){
            int cnt = 0;
            int nx = x;
            int ny = y;

            while (true){
                nx += dx[d];
                ny += dy[d];

                // 범위 넘어가면
                if(checkRange(nx, ny)) break;
                // 전선이나 코어를 만나면 다른 방향으로
                if(processor[nx][ny]==1){
                    cnt = 0;
                    break;
                }
                cnt++;
            }

            // count 개수만큼 1로 채운다.
            int fill_x = x;
            int fill_y = y;

            for (int i=0; i<cnt; i++){
                fill_x += dx[d];
                fill_y += dy[d];
                processor[fill_x][fill_y] = 1;
            }

            // 카운트가 0 -> 전선 설치 불가, 다음 탐색ㄱ
            if(cnt == 0 ) connect(idx+1, coreCnt, wireLen);
            else{
                // 전선 설치, 코어 증가, 전선 길이 증가, 다음 탐색으로
                connect(idx+1, coreCnt+1, wireLen+cnt);

                // DFS 이후 전선 해제
                fill_x = x;
                fill_y = y;
                for (int i=0; i<cnt; i++){
                    fill_x += dx[d];
                    fill_y += dy[d];
                    processor[fill_x][fill_y] = 0;
                }
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        if(x<0 || x>=N || y<0 || y>=N) return true;
        return false;
    }
}
