class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        int num = n/2;
        int r = n%2;
        
        while(num>0){
            sb.append("수박");
            num--;
        }
        
        if(n%2==1) sb.append("수");
        
        return sb.toString();
    }
}