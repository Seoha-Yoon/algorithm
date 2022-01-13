import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length/2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: nums){
            if(set.isEmpty()){
                answer++;
                set.add(n);
            }else{
                if(!set.contains(n)){
                    answer++;
                    set.add(n);
                }
            }
            
            if(answer>=N) return answer;
        }
        
        return answer;
    }
}