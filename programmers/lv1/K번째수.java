import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k;
        
        for(int n=0; n<commands.length; n++){
            i = commands[n][0];
            j = commands[n][1];
            k = commands[n][2];
            
            int[] arr = Arrays.copyOfRange(array, i-1, j);
            
            Arrays.sort(arr);
            answer[n] = arr[k-1];
        }
        
        return answer;
    }
}