import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int cost = 0;
        
        Arrays.sort(d);
        
        for(int p: d){
            cost += p;
            
            if(cost<=budget) answer++;
            else break;
        }
        
        return answer;
    }
}