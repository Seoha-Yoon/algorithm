package String;

import java.util.ArrayList;
import java.util.Scanner;

// 4. 단어 뒤집기 - StringBuilder 사용

/*
3
good
Time
Big


doog
emiT
giB
 */

public class String4 {
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String s: str){
            StringBuilder sb = new StringBuilder(s);
            answer.add(sb.reverse().toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        String4 T = new String4();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        String[] str = new String[N];

        for (int i = 0; i < N; i++)
            str[i] = kb.next(); // 문자열 읽기

        for (String x: T.solution(N, str))
            System.out.println(x);
    }
}