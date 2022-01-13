import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 변수들 초기값 설정
        Arrays.sort(times);
        long start = 1;
        
        long end = (long)times[times.length-1] * (long)n;
        long mid = 0;
        
        // 사람 수가 입국 심사대 보다 적다면
        if(n<=times.length){
            // n번째만큼 큰 시간만큼 시간이 걸리는게 최대 시간 가정
            answer = times[n-1]; 
        }else answer = end;
        
        while(start<=end){
            mid = (start+end)/2;
            
            if(checkTime(n, times, mid)){
                // answer 값 갱신
                answer = mid<answer? mid:answer;
                end = mid - 1;
            }else{
                // start 값 갱신
                start = mid + 1; // mid값 뒷부분
            }
            System.out.println(start +","+ end+","+ answer);
            
        }
        return answer;
    }
    
    // mid 시간 안에 입국 심사 받을 수 있는 사람 수
    public boolean checkTime(long n, int[] times, long midTime){
        long cnt = 0;
        
        for(long time: times){
            cnt += midTime/time;
        }
        
        // 입국 심사 받을 수 있는 사람 수가 기다리는 사람 수 보다 크면 Ok
        if(cnt >= n) return true;
        else return false;
    }
}