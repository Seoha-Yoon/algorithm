package String;

import java.util.Scanner;
import java.util.HashSet;

/*
ksekkset

kset
 */

// 6. 중복문자제거
public class String6 {
    public String solution(String str){
        String answer = "";

        HashSet<Character> set = new HashSet<>();

        for(char c: str.toCharArray()){
            if(!set.isEmpty()){
                if(!set.contains(c)){
                    answer+=c;
                    set.add(c);
                }
            }else{
                answer+=c;
                set.add(c);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String6 T = new String6();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}