import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 초깃값 초기화
        int start = 1;
        int end = distance;
        int mid, cur, cnt;
        int tot = rocks.length;
        
        // 바위 위치 sort
        Arrays.sort(rocks);
        
        // 거리를 기준으로 이분탐색 시작
        while(start<=end){
            // mid 값 정해주기
            mid = (start + end)/2;
            System.out.println("mid: "+mid);
            cur = 0;
            cnt = 0;
            int min = Integer.MAX_VALUE;
            
            
            // mid 보다 큰 바위 위치 계산
            for(int rock: rocks){
                // 바위 사이의 거리가 mid 보다 작으면 부시기
                if((rock - cur) < mid){
                    cnt++;
                }else{
                    // 최소 거리 갱신
                    min = Math.min(min, rock-cur);
                    cur = rock;
                }
            }
            
            // 마지막 바위와 도착지점 사이의 거리 계산
            if(distance - rocks[tot-1] < mid) cnt++;
            else min = Math.min(min, distance - rocks[tot-1]);
            
            // 만약 부신 바위의 개수가 n 보다 크면 end 값 갱신
            if(cnt > n){
                end = mid - 1;
                
            }else{
                // n보다 크면 start 값 갱신
                start = mid + 1;
                answer = min;
            }
            System.out.println("min: "+min);

        }
        return answer;
    }
}