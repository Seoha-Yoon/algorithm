package String;

import java.util.Scanner;

// 10. 가장 짧은 문자거리
public class String10 {
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
        String10 T = new String10();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));
    }
}