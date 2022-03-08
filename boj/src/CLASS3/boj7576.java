package CLASS3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {

    static int N, M;
    static int[][] box, cntDate;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        box = new int[N][M];
        cntDate = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        progress();

        System.out.println(cal());

    }

    private static void progress() {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && box[i][j]==1) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Point cur = q.poll();

            for (int k = 0; k < 4 ; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx <0 || ny <0 || nx>=N || ny>=M) continue;

                if(!visited[nx][ny] && box[nx][ny] == 0){
                    visited[nx][ny] = true;
                    box[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                    // 날짜 업데이트
                    cntDate[nx][ny] = cntDate[cur.x][cur.y] + 1;
                }
            }
        }

    }

    private static int cal(){
        int day = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0) return -1;
                day = Math.max(day, cntDate[i][j]);
            }
        }

        return day;
    }
}
