package String;

import java.util.Scanner;

// 11. 문자열 압축
/*
KKHSSSSSSSE
K2HS7E

KSTTTSEEKFKKKDJJGG
KST3SE2KFK3DJ2G2
 */

public class String11 {
    public String solution(String str){
        String answer = "";
        int hit = 1;
        char before = str.charAt(0);

        for (int i=1; i<str.length(); i++){
            if(before == str.charAt(i)){
                hit++;
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(before);
                if(hit!=1)
                    sb.append(hit);
                hit = 1;
                before = str.charAt(i);
                answer += sb.toString();
            }
        }

        answer+=str.charAt(str.length()-1);
        if(hit!=1)
            answer+=hit;

        return answer;
    }

    public static void main(String[] args){
        String11 T = new String11();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}