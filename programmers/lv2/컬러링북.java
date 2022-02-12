import java.util.Stack;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] picture;
    int m, n;
    boolean[][] visited;
    
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        
        // init
        this.picture = picture;
        this.m = m;
        this.n = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j));
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    int dfs(int x, int y){
        Stack<Point> stk = new Stack<>();
        stk.push(new Point(x, y));
        visited[x][y] = true;
        int area = 0;
        
        while(!stk.isEmpty()){
            Point cur = stk.pop();
            int curX = cur.x;
            int curY = cur.y;
            int color = picture[curX][curY];
            area++;
            
            for(int k=0; k<4; k++){
                int nx = curX + dx[k];
                int ny = curY + dy[k];
            
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            
                if(picture[nx][ny] == color && !visited[nx][ny]){
                    stk.push(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return area;
        
    }
}