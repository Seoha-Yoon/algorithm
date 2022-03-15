package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16236 {

    static int map[][];
    static int size = 2; // initial size
    static int N, time;

    static class Point implements Comparable<Point>{
        int x, y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(point.distance == this.distance){
                if(point.x == this.x) return this.y - point.y;
                return this.x - point.x;
            }
            return this.distance - point.distance;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int x=0, y=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    x = i;
                    y = j;
                }
            }
        }

        time=0;
        calculateTime(x, y);

        bw.write(Integer.toString(time));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void calculateTime(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(x, y, 0));
        int cnt = 0;
        while (!pq.isEmpty()){
            Point cur = pq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            if(map[cur_x][cur_y] == 0) continue;

            map[cur_x][cur_y] = 0;
            time += cur.distance;

            pq.clear();
            int[][] dist = calDistance(cur_x, cur_y, new int[N][N]);


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] < size && map[i][j]!=0 && dist[i][j]!=-1){
                        int d = dist[i][j];

                        pq.add(new Point(i, j, d));
                    }
                }
            }

            cnt++;
            if(cnt == size){
                size++;
                cnt = 0;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static int[][] calDistance(int x, int y, int[][] dist) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visited[nx][ny] && map[nx][ny] <= size){
                    visited[nx][ny] = true;
                    dist[nx][ny] += dist[cur.x][cur.y]+1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 못하는 경우
                if(!visited[i][j]) dist[i][j] = -1;
            }
        }

        return dist;
    }
}
