package String;

import java.util.Scanner;

/*
found7, time: study; Yduts; emit, 7Dnuof

YES
 */

// 8. 유효한 팰린드롬
public class String8 {
    public String solution(String str){
        StringBuilder sb = new StringBuilder();

        // 대소문자 구분 안함
        str = str.toLowerCase();
        char[] arr = str.toCharArray();

        for (int i=0; i<arr.length;i++){
            if(checkAlphabet(arr[i])) sb.append(arr[i]);
        }

        StringBuilder str1 = new StringBuilder(sb.substring(0,sb.length()/2));
        String str2 = sb.length()%2==1?sb.substring(sb.length()/2+1):sb.substring(sb.length()/2);

        if(str1.reverse().toString().equals(str2)) return "YES";

        return "NO";
    }

    private boolean checkAlphabet(char c){
        return (c>=65 && c<=90)||(c>=97 && c<=122);
    }

    public static void main(String[] args){
        String8 T = new String8();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}