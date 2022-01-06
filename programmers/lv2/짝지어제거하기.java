import java.util.*;

class Solution
{
    public int solution(String s)
    {

        if(s.length()%2==1){
            return 0;
        }else{
            return checkRemovable(s);
        }

    }
    
    private int checkRemovable(String s){
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(stk.isEmpty()){
                stk.push(c);
                continue;
            }
            
            if(stk.peek()==c){
                stk.pop();
            }else{
                stk.push(c);
            }
        }
        
        if(stk.isEmpty()) return 1;
        else return 0;
    }
}