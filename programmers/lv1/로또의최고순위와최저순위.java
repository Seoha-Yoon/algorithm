import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int i=0, hit = 0, zero=0;
        
        // 알고 있는 숫자 중 맞은 개수
        while(i<6){
            if(lottos[i] == 0){
                zero++;
                i++;
                continue;
            }
            
            for(int j=0; j<6; j++){
                if(lottos[i]==win_nums[j]){
                    hit++;
                    break;
                }
            }
            i++;
        }
        
        answer[0] = 6 - (hit+zero) +1;
        answer[1] = 6 - hit + 1;
        
        if(answer[0] >= 6) answer[0] =6;
        
        if(answer[1] >= 6) answer[1] =6;
        
        return answer;
    }
}