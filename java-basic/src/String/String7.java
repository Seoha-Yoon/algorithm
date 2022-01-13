package String;

import java.util.Scanner;

/*
gooG

YES
 */

// 7. 회문문자열
public class String7 {
    public String solution(String str){
        String answer = "YES";
        str = str.toLowerCase();
        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length/2; i++)
            if(arr[i]!=arr[arr.length-i-1]) return "NO";

        return answer;
    }

    public static void main(String[] args){
        String7 T = new String7();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}