package String;

import java.util.Scanner;

// 9. 숫자만 추출
/*
g0en2T0s8eSoft

208
 */

public class String9 {
    public int solution(String str){
        String answer = "";

        // 대소문자 구분 안함
        char[] arr = str.toCharArray();

        for (int i=0; i<arr.length;i++){
            int n = arr[i] - '0';
            if(n>=0 && n<=9) answer += arr[i];
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args){
        String9 T = new String9();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}