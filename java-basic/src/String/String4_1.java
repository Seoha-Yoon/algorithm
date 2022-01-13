package String;

import java.util.ArrayList;
import java.util.Scanner;

// 4. 단어 뒤집기 - 직접 swap 함수 짜기 (for 사용)
public class String4_1 {
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String s: str){
            char[] tmp = s.toCharArray();

            for(int i=0; i<tmp.length/2; i++) {
                char c = tmp[i];
                tmp[i] = tmp[tmp.length-1-i];
                tmp[tmp.length-i-1] = c;
            }
            answer.add(String.valueOf(tmp));
        }
        return answer;
    }

    public static void main(String[] args) {
        String4_1 T = new String4_1();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        String[] str = new String[N];

        for (int i = 0; i < N; i++)
            str[i] = kb.next(); // 문자열 읽기

        for (String x: T.solution(N, str))
            System.out.println(x);
    }
}