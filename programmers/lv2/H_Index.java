class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for(int h=0; h<=citations.length;h++){
            int num=0;

            for(int i=0; i<citations.length;i++){
                if(citations[i]>=h) num++;
            }

            if(num>=h) answer = h;
        }

        return answer;
    }
}