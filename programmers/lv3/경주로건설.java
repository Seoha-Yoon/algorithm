import java.util.LinkedList;
import java.util.Queue;

class Road{
        int x, y, cost, dir;
        public Road(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
}

class Solution {
   
    static int xx[] = {-1, 0, 1, 0};
    static int yy[] = {0, -1, 0, 1};
    static int map[][];
    static int n;
    static int answer;
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        map = board;
        
        bfs(0,0,0,-1);
        return answer;
    }
    
    public static void bfs(int x, int y, int cost, int dir){
        Queue<Road> queue = new LinkedList<Road>();
        queue.add(new Road(x, y, cost, dir));
        
        map[x][y] = 1;
        
        while(!queue.isEmpty()){
            Road temp = queue.poll();
            if(temp.x == n-1 && temp.y == n-1){
                answer = Math.min(answer, temp.cost);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int newX = temp.x + xx[i];
                int newY = temp.y + yy[i];
                
                if(newX >=0 && newX<n && newY>=0 && newY<n && map[newX][newY]!=1){
                    int new_cost = 0;
                    if(temp.dir == -1 || temp.dir == i){
                        new_cost = temp.cost + 100;
                    }else if(temp.dir != i){
                        new_cost = temp.cost + 600;
                    }
                    
                    if(map[newX][newY] ==0){
                        map[newX][newY] = new_cost;
                        queue.add(new Road(newX, newY, new_cost, i));
                    }else if(map[newX][newY] >= new_cost){
                        map[newX][newY] = new_cost;
                        queue.add(new Road(newX, newY, new_cost, i));
                    }
                }
            }
        }
    }
    
}