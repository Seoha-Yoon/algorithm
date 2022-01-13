package String;

import java.util.ArrayList;
import java.util.Scanner;

// 4. 단어 뒤집기 - 직접 swap 함수 짜기 (while)
public class String4_2 {
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String s: str){
            char[] tmp = s.toCharArray();
            int lt = 0, rt = s.length()-1;

            while (lt<rt){
                char c = tmp[lt];
                tmp[lt] = tmp[rt];
                tmp[rt] = c;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(tmp));
        }
        return answer;
    }

    public static void main(String[] args) {
        String4_2 T = new String4_2();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        String[] str = new String[N];

        for (int i = 0; i < N; i++)
            str[i] = kb.next(); // 문자열 읽기

        for (String x: T.solution(N, str))
            System.out.println(x);
    }
}