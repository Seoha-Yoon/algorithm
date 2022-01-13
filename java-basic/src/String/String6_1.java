package String;

import java.util.Scanner;
import java.util.HashSet;

/*
ksekkset

kset
 */
// 6. 중복문자제거 (indexOf 사용)
public class String6_1 {
    public String solution(String str){
        String answer = "";

        for(int i=0; i<str.length(); i++){
            // System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            // indexOf == i 같아야 처음 등장한 경우
            if(str.indexOf(str.charAt(i))==i)
                answer+=str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args){
        String6_1 T = new String6_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}