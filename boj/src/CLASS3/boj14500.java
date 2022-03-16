package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14500 {

    static final int COUNT = 4;
    static int N, M, maxSum;
    static int[][] paper;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxSum = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                findSum(i , j, paper[i][j], 1, visited);
                visited[i][j] = false;
            }
        }

        bw.write(Integer.toString(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 ,-1, 1};
    private static void findSum(int x, int y, int sum, int cnt, boolean[][] visited) {
        if(cnt == COUNT){
            maxSum = Math.max(sum, maxSum);
            return;
        }


        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx <0 || nx>=N || ny<0 || ny>=M) continue;
            if(!visited[nx][ny]){
                if(cnt == 2){
                    visited[nx][ny] = true;
                    findSum(x, y, sum+paper[nx][ny], cnt+1, visited);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                findSum(nx, ny, sum+paper[nx][ny], cnt+1, visited);
                visited[nx][ny] = false;
            }
        }
    }
}
