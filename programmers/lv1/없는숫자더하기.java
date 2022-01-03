public class Solution {
    public int solution(int[] numbers) {
        // 1부터 9까지 다 더한 값
        int answer = 45;
        
        for(int n: numbers)
            answer -=n;
        
        return answer;
    }
}
