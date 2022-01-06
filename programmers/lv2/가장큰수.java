import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        
        // int배열을 string배열로 바꿔준다.
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }
        
        // string 배열 sort 앞뒤로 두 숫자를 합친게 더 큰 순서대로 sorting
        Arrays.sort(nums, new Comparator<String>(){
           public int compare(String s1, String s2){
               return (s2+s1).compareTo(s1+s2);
           } 
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            sb.append(nums[i]);
        }
        
        answer = sb.toString();
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}