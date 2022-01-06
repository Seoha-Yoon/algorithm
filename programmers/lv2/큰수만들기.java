class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);

        // k번 제거
        for(int i=0; i<k; i++){
            int len = answer.length();
            int index = len-1;
            
            // i번째의 숫자가 i+1번째 숫자보다 작으면 해당 인덱스 제거
            for(int j=0; j<len-1;j++){
                if(answer.charAt(j)<answer.charAt(j+1)){
                    index = j;
                    break;
                }
            }
            
            answer = answer.deleteCharAt(index);
        }

        return answer.toString();
    }
}