import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int before = -1; // 바로 전 숫자
        for(int i=0; i<arr.length; i++){
            if(arr[i] != before)
                list.add(arr[i]);
            
            before = arr[i];
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}