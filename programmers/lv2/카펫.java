class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow%i==0){
                answer[1] = i+2;
                answer[0] = yellow/i+2;
                
                int area = answer[0]*answer[1];
                if(area == brown+yellow){
                    return answer;
                }
            }
        }
        
        return answer;
    }
}