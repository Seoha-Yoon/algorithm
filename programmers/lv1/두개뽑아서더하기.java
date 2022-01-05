import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 더한 수를 저장할 Set
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length-1; i++){
            int addNum = 0;
            for(int j=i+1; j<numbers.length; j++){
                addNum = numbers[i] + numbers[j];
                set.add(addNum);
            }
        }
        
        // set을 배열로
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        
        return answer;
    }
}