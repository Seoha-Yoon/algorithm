import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth: clothes){
            if(map.isEmpty()){
                map.put(cloth[1], 1); 
                continue;
            }
            
            if(map.containsKey(cloth[1])){
                map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
            }else{
                map.put(cloth[1], 1);
            }
        }
        
        Collection<Integer> values = map.values();
        
        for(Integer i: values){
            answer *= i+1;
        }
        answer--;
            
        return answer;
    }
}