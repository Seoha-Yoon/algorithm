package CLASS3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2178 {
    static int N, M;
    static int[][] map, cnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][M+1];

        // init map
        for (int i = 1; i <= N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j+1] = str.charAt(j) - '0';
            }
        }

        cnt = new int[N+1][M+1];
        bfs(1,1);

        System.out.println(cnt[N][M]+1);
    }

    private static void bfs(int r, int c) {
        boolean visited[][] = new boolean[101][101];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();
            if(cur.r ==N && cur.c == M) return;

            for(int k=0; k<4; k++){
                int nr = cur.r + dx[k];
                int nc = cur.c + dy[k];

                if(nr<=0 || nc<=0 || nr>N || nc>M) continue;

                if(!visited[nr][nc] && map[nr][nc]==1){
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    cnt[nr][nc] = cnt[cur.r][cur.c]+1;
                }
            }
        }
    }
}
