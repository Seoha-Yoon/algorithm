import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            int A = pq.poll();
            int B = pq.poll();
            
            pq.add(A + B*2);
            answer++;
            
            if(pq.peek()>=K) break;
            if(pq.size()==1) return -1;
        }
        
        return answer;
    }
}