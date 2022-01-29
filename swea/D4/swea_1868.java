package DAY7;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prob20 {

    // 확인할 방향
    static int[] dx ={-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static char[][] map;
    static int N;
    static int[][] cnt;

    // point class
    static class Point{
        int x; int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY7/input20.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            map = new char[N][N];
            cnt = new int[N][N]; // 지뢰 개수 저장 cnt

            for(int i=0; i<N; i++){
                String str = sc.next();
                map[i] = str.toCharArray();
            }

            // 지뢰 개수 찾기
            cntMine();

            int res=0;
            // 지뢰 개수가 0인 부분부터 누른다.
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(cnt[i][j]==0 && map[i][j]!='*'){
                        popping(i, j);
                        res++;
                    }
                }
            }

            // 아직 터지지 누르지 않은 곳을 누른다.
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(cnt[i][j]>0 && map[i][j]!='*'){
                        res++;
                    }
                }
            }

            System.out.println("#"+test_case+" "+res);
        }
    }

    // dfs
    private static void popping(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        cnt[x][y] = -1; // 방문여부. 방문하면 -1

        while (!q.isEmpty()){
            Point cur = q.poll();
            for(int k=0; k<8; k++){
                int xx = cur.x + dx[k];
                int yy = cur.y + dy[k];

                // 범위를 벗어나거나, 방문했거나, 지뢰라면 pass
                if(xx<0 || xx>=N || yy<0 || yy>=N || map[xx][yy]=='*'||cnt[xx][yy]==-1) continue;

                // 다음 곳도 지뢰가 주변에 없다면 queue에 넣어서 popping
                if(cnt[xx][yy]==0){
                    q.add(new Point(xx, yy));
                }
                cnt[xx][yy]=-1;
            }
        }
    }

    private static void cntMine() {
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(map[x][y]=='.'){
                    int count = 0;
                    for(int k=0; k<8; k++){
                        int xx = x + dx[k];
                        int yy = y + dy[k];

                        // 범위를 벗어나거나 지뢰가 아니면 pass
                        if(xx<0 || xx>=N || yy<0 || yy>=N || map[xx][yy]!='*') continue;
                        count++;
                    }
                    cnt[x][y] = count;
                }
            }
        }
    }

}
