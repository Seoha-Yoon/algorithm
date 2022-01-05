class Solution {
    public String solution(String s) {
        
        int len = s.length();
        String answer = "";
        
        if(len % 2 != 0){
            return s.substring(len/2, len/2+1);
        }else{
            return s.substring(len/2-1, len/2+1);
        }
        
    }
}