class Solution {
    
    // 약수의 개수
    private int nDivisor(int num){
        int n = 0;
        for(int i=1; i <= Math.sqrt(num); i++){
            if(num % i == 0) n++;
        }
        
        if(num % Math.sqrt(num) == 0) return 2*n+1;
        else return 2*n;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i<=right; i++){
            if(nDivisor(i)%2==0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
}