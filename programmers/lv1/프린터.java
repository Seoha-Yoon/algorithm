import java.util.*;

class Solution {
    class Print{
        int loc;
        int priority;
        
        public Print(int loc, int priority){
            this.loc = loc;
            this.priority = priority;
        }
    }
    Queue<Print> queue;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.add(new Print(i, priorities[i]));    
        }
        
        while(!queue.isEmpty()){
            Print print = queue.poll();
            if(checkCanPrint(print.priority)){
                answer++;
                if(print.loc == location) return answer;
            }
            else {
                queue.add(print);
            }
        }
        return answer;
    }
    
    public boolean checkCanPrint(int prior){
        Queue<Print> q = new LinkedList<>(queue);
        
        while(!q.isEmpty()){
            if(q.poll().priority > prior) return false;
        }
        return true;
    }
}