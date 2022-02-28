package CLASS3;

import java.util.Scanner;

public class boj1012 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, M;
    static int[] ans;
    static int[][] farm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ans = new int[T];

        for (int t=0; t<T; t++){
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            farm = new int[M][N];

            for(int i=0; i<K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                farm[x][y] = 1;
            }

            ans[t] = 0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(farm[i][j] == 1){
                        dfs(i,j);
                        ans[t]++;
                    }
                }
            }
        }

        for (int an : ans) {
            System.out.println(an);
        }
    }

    public static void dfs(int x, int y){
        farm[x][y] = 0;
        for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx<0 || nx>=M || ny<0 || ny>=N) continue;

            if(farm[nx][ny] == 1) dfs(nx, ny);
        }
    }
}
