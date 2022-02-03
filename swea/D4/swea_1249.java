package DAY11;

import java.io.FileInputStream;
import java.util.*;

// bfs 풀이
// pq bfs, 다익스트라로도 풀어보기!
public class Prob33 {
    static int N;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static int minTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY11/input33.txt"));


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            sc.nextLine();

            map = new int[N][N];
            visited = new boolean[N][N];
            ans = new int[N][N];

            for(int i=0; i<N; i++){
                String str = sc.nextLine();
                for (int j=0; j<N; j++){
                    map[i][j] = str.charAt(j)-'0';
                }
            }

            minTime = Integer.MAX_VALUE;
            for (int i=0; i<N; i++)
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            ans[0][0] = 0;

            bfs(0,0);

            System.out.println("#"+test_case+" "+minTime);

        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Pos cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            if(curX==N-1 && curY==N-1)
                minTime = Math.min(ans[curX][curY], minTime);

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY +dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

                if(!visited[nx][ny] || ans[nx][ny]>ans[curX][curY]+map[nx][ny]){
                    visited[nx][ny] = true;
                    ans[nx][ny] = ans[curX][curY] + map[nx][ny];
                    q.offer(new Pos(nx,ny));
                }
            }

        }

    }
}
