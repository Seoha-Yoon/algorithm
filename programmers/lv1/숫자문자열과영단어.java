class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ca = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<ca.length; i++){
            if(ca[i]>='0' && ca[i]<='9')
                sb.append(ca[i]);
            else{
                switch(ca[i]){
                    case 'z':
                        sb.append('0');
                        i += 3;
                        break;
                    case 'o':
                        sb.append('1');
                        i += 2;
                        break;
                    case 't':
                        if(ca[i+1]=='w'){
                            sb.append('2');
                            i += 2;
                        }else{
                            sb.append('3');
                            i += 4;
                        }
                        break;
                    case 'f':
                        if(ca[i+1]=='o'){
                            sb.append('4');
                            i += 3;
                        }else{
                            sb.append('5');
                            i += 3;
                        }
                        break;
                    case 's':
                        if(ca[i+1]=='i'){
                            sb.append('6');
                            i += 2;
                        }else{
                            sb.append('7');
                            i += 4;
                        }
                        break;
                    case 'e':
                        sb.append('8');
                        i += 4;
                        break;
                    case 'n':
                        sb.append('9');
                        i += 3;
                        break;
                }
                if(i>=ca.length) break;
                
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}