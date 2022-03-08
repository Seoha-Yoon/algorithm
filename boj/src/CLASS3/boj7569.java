package CLASS3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj7569 {
    // 위, 아래, 왼, 오, 앞, 뒤
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    // 토마토 상자
    static int[][][] box, cntDate;
    static int N, M, H;
    static boolean[][][] visited;

    static class Point{
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[M][N][H];
        cntDate = new int[M][N][H];
        visited = new boolean[M][N][H];

        // box 초기화, 1 = 익은, 0 = 덜 익은, -1 = 없는
        for (int i = 0; i <H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[k][j][i] = sc.nextInt();
                }
            }
        }


        int day = 0;
        for (int i = 0; i <M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < H; k++) {
                    // 익힌 상황 업데이트
                    if (box[i][j][k] == 1 && !visited[i][j][k]) {
                        progress(i, j, k);
                    }
                }
            }
        }

        for (int i = 0; i <M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < H; k++) {
                    // 안 익은 토마토가 있으면
                    if(box[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, cntDate[i][j][k]);
                }
            }
        }
        System.out.println(day);
    }

    private static void progress(int m, int n, int h) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(m , n, h));
        visited[m][n][h] = true;

        while (!queue.isEmpty()){
            Point cur = queue.poll();

            for(int d=0; d<6; d++){
                int xx = cur.x + dx[d];
                int yy = cur.y + dy[d];
                int zz = cur.z + dz[d];

                if(xx<0 || yy<0 || zz<0 || xx>=M || yy>=N || zz>=H) continue;

                if(!visited[xx][yy][zz] && box[xx][yy][zz]==0){
                    visited[xx][yy][zz] = true;
                    box[xx][yy][zz] = 1;
                    queue.add(new Point(xx, yy, zz));
                    cntDate[xx][yy][zz] = cntDate[cur.x][cur.y][cur.z]+1;
                }
            }
        }
    }

    public static void printBox(){
        for (int i = 0; i <H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(box[k][j][i]+" ");
                }
                System.out.println();
            }
        }
    }
}
