import java.util.*;


class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

// BFS
class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int[][] dist; // 최단거리 저장 
    int n, m;
    int[][] maps;
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        bfs(0, 0);
        
        if(dist[n-1][m-1] == 0) answer = -1;
        else answer = dist[n-1][m-1]+1;
        
        return answer;
    }
    
    private void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        maps[x][y] = -1;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            
            for(int d=0; d<4; d++){
                int nx = curX+dx[d];
                int ny = curY+dy[d];
                
                if(nx >= n || nx < 0 || ny <0 || ny>=m) continue;
                if(maps[nx][ny]==1){
                    q.add(new Point(nx,ny));
                    maps[nx][ny]=-1;
                    dist[nx][ny] = dist[curX][curY] + 1;
                }
            }
        }
    }
}