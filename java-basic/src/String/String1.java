package String;

import java.util.Scanner;

// 1. 문자 찾기
public class String1 {
    public int solution(String str, char c){
        int answer=0;

        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        for(char s: str.toCharArray()){
            if(c==s) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        String1 T = new String1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));
    }
}