class Solution {
    public int[] solution(long n) {
        
        String s = Long.toString(n);
        
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            answer[i] = s.charAt(s.length()-i-1)-'0';
        }
        return answer;
    }
}