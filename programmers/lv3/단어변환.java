import java.util.*;

class Solution {
    
    boolean[] visited;

    int dfs(String begin, String target, int num, String[] words, int ans){
        
        if(begin.equals(target)) return num-1;
        
        for(int i=0;i<words.length;i++){
            if(!visited[i] && checkAdjacent(begin,words[i])){
                visited[i] = true;
                ans = Math.min(ans, dfs(words[i],target,num+1,words, ans));
                visited[i] = false;
            }
        }

        return ans;
    }
    
    // 알파벳 하나가 같으면 adjacent
    boolean checkAdjacent(String a, String b){
        int num = 0;
        
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)) num++;
        }
        
        return num==1;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = dfs(begin, target, 1, words, Integer.MAX_VALUE);
        return (answer==Integer.MAX_VALUE)?0:answer;
    }
}