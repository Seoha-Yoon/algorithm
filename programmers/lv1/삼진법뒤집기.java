class Solution {
    
    // 10진법 -> 3진법
    private String decimalToBase3(int n){
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.append(n%3);
            n /= 3;
        }
        
        return sb.toString();
    }
    
    // 3진법 -> 10진법
    private int base3ToDecimal(String s){
        StringBuilder sb = new StringBuilder();
        int decimalNum = 0;
        int k = 1;
        
        for(int i=s.length()-1; i>=0; i--){
            int n = s.charAt(i) -'0';
            decimalNum += k*n;
            k *= 3;
        }
        return decimalNum;
    }
    
    public int solution(int n) {
        int answer = base3ToDecimal(decimalToBase3(n));
        
        return answer;
    }
    
}