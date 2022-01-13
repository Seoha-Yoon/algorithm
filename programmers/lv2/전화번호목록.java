import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }    
        });// 문자열 짧은 순서대로 sort
        
        int slen = phone_book[0].length();
        int mlen = phone_book[0].length();
        for(String phone_num: phone_book){
            mlen++;
            // set이 비어있을 때
            if(set.isEmpty()){
                mlen = phone_num.length();
                set.add(phone_num);
                continue;
            }

            for(int i=slen; i<=mlen; i++){
                if(set.contains(phone_num.substring(0,i))){
                    return false;
                }
                else{
                    mlen = phone_num.length()-1;
                    set.add(phone_num);
                }
            }
        }
        return answer;
    }
}