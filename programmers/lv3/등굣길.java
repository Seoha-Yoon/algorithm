class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m][n];
        final int mod = 1000000007;
        
        // build map
        for(int[] puddle: puddles){
            map[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        map[0][0] = 1;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]!=-1){
                    map[i][j] += checkLeft(map, i, j);
                    map[i][j] += checkUp(map,i, j);
                    map[i][j] %= mod;
                }
            }
        }
        answer = map[m-1][n-1];
        return answer;
    }
    
    public int checkLeft(int[][] map, int x, int y){
        if(y!=0 && map[x][y-1]!=-1){
            return map[x][y-1];
        }
        return 0;
    }
    
    public int checkUp(int[][] map, int x, int y){
        if(x!=0 && map[x-1][y]!=-1){
            return map[x-1][y];
        }
        return 0;
    }
}