import java.util.*;

class Solution {
    static int count = 0;
    
    public int solution(int[] nums) {
        int answer = -1;
        boolean[] visited = new boolean[nums.length];

        findComb(nums, visited, 0, 3);
        
        answer = count;

        return answer;
    }
    
    // 소수 구하기
    public boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i ==0) return false;
        }
        return true;
    }
    
    // 조합의 합 구하기
    public void findComb(int[] arr, boolean[] visited, int cur, int r){
        // 3개 뽑으면 sum이 소수인지 구하기
        if(r==0){
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]) sum+=arr[i];
            }
            
            if(isPrime(sum)){
                count++;
            }
            
            System.out.println(sum+", "+count);
            return;
        }
        if(cur == arr.length) return;
        else {
            visited[cur] = true;
            findComb(arr, visited, cur + 1, r - 1);
 
            visited[cur] = false;
            findComb(arr, visited, cur + 1, r);
        }
    }
}