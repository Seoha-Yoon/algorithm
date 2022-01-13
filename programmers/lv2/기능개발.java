import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        // program의 남은일수를 queue에 저장
        for(int i=0; i<progresses.length; i++){
            queue.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
            
        }
        
        int day = 1;
        int num = 0;
        while(!queue.isEmpty()){
            num = 0;
            while(queue.peek()<=day){
                queue.remove();
                num++;
                if(queue.isEmpty()) break;
            }
            day++;
            if(num!=0) result.add(num);
        }
        
        int[] answer = new int[result.size()];
        
        for(int r=0; r<result.size();r++){
            answer[r]=result.get(r);
        }
        
        return answer;
    }
}
