class Solution {
    
    public int dfs(int index, int[][] computers, boolean[] marked){
        if(marked[index]) return 0;
        
        marked[index] = true;
        for(int j=0; j<computers[index].length; j++){
            if(computers[index][j] == 1)
                dfs(j, computers, marked);
        }
        return 1;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] marked = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!marked[i]) answer += dfs(i, computers, marked);
        }
        
        return answer;
    }
}