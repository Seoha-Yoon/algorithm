package String;

import java.util.Scanner;
/*
gooG

YES
 */

// 7. 회문문자열 (StringBuilder 사용)
public class String7_1 {
    public String solution(String str){
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();

        // 대소문자 구별X
        if(str.equalsIgnoreCase(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args){
        String7_1 T = new String7_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}