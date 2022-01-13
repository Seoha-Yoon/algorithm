class Solution {
    public int solution(String s) {
        
        // 문자열 단위 가장 긴 길이부터
        int cnt = s.length()/2+1;
        int minLen = Integer.MAX_VALUE;
        
        // 단위가 0보다 클 때 동안
        while(cnt>0){
            
            int len = s.length();
            // 같은 문자가 반복되는 횟수
            int match=1;
            
            for(int i=0; i<s.length()-cnt; i+=cnt){
                String s1 = s.substring(i,i+cnt);
                
                if(i+2*cnt<=s.length()){
                    
                    String s2 = s.substring(i+cnt,i+2*cnt);
                    
                    if(s1.equals(s2)){
                        len -= cnt;
                        match++;
                        
                        if(s.length()==i+2*cnt){
                            // 동일한 패턴 앞에 더해지는 숫자 계산
                            if(match>1 && match<=9) len++;
                            else if(match>=10) len+=2;
                        }
                        
                    }else{
                        // 동일한 패턴 앞에 더해지는 숫자 계산
                        if(match>1 && match<=9) len++;
                        else if(match>=10) len+=2;
                        
                        // match 1로 초기화
                        match = 1;
                    }
                }else{
                        // 동일한 패턴 앞에 더해지는 숫자 계산
                        if(match>1 && match<=9) len++;
                        else if(match>=10) len+=2;
                        
                        // match 1로 초기화
                        match = 1;
                    }
            }
            
            
            if(len<=minLen) minLen = len;
            cnt--;
        }
        
        return minLen;
    }
}