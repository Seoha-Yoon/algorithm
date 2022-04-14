import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = changeNumber(n, k);
        String[] arr = s.split("0");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("")) continue;
            long num = Long.parseLong(arr[i]);
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    // k진수로 바꾸기
    private String changeNumber(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n!=0){
            int r = n % k;
            n /= k;
            sb.append(r);
        }
        
        return sb.reverse().toString();
    }
    
    // 소수판별
    private boolean isPrime(long num){
        if(num == 1) return false;
        if(num == 2) return true;
        
        for(int i=3; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}