package String;

import java.util.Scanner;

// 11. 문자열 압축
/*
KKHSSSSSSSE
K2HS7E

KSTTTSEEKFKKKDJJGG
KST3SE2KFK3DJ2G2
 */

public class String11_1 {
    public String solution(String str){
        String answer = "";
        str = str+" "; // 앞 뒤 문자 비교할 때 마지막 문자 처리
        int hit = 1;

        for (int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                hit++;
            }else{
               answer+=str.charAt(i);
               if(hit>1) answer+=String.valueOf(hit);
               hit=1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String11_1 T = new String11_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}