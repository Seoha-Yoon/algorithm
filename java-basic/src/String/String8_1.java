package String;

import java.util.Scanner;

/*
found7, time: study; Yduts; emit, 7Dnuof

YES
 */

// 8. 유효한 팰린드롬(replaceAll 사용)
public class String8_1 {
    public String solution(String str){
        String answer = "NO";

        // 대소문자 구분 안함
        // 대문자가 아니면 다 제거시키기
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args){
        String8_1 T = new String8_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}