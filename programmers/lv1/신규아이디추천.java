class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        
        // 2단계
        for(int i=0; i<sb.length(); i++){
            // System.out.println(sb.toString());
            char c = sb.charAt(i);
            // 만약 소문자 or 숫자라면 pass
            if((c>=97 && c<=122) || (c>=48 && c<=57)) continue;
            // -, _ 라면 pass
            else if(c == '-' || c == '_' || c == '.'){
                continue;
            }
            // 이외 문자 삭제
            else{
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        
        // 3단계
        int hits=0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '.') hits++;
            else hits=0;

            if(hits==2){
                sb.deleteCharAt(i);
                i--;
                hits--;
            }
        }

        // 4단계
        if(sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.'){
            sb.deleteCharAt(sb.length()-1);
        }
        
        // 5단계
        if(sb.length()==0) sb.append('a');
        
        // 6단계
        if(sb.length()>=16){
            sb.delete(15, sb.length());
            if(sb.charAt(sb.length()-1) == '.')sb.deleteCharAt(sb.length()-1);
        }
        
        // 7단계
        if(sb.length()<=2){
            char ch = sb.charAt(sb.length()-1);
            while(sb.length()<3)
                sb = sb.append(ch);
        }
        
        answer = sb.toString();
        return answer;
    }
}