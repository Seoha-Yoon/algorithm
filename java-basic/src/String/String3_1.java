package String;

import java.util.Scanner;

// 3. 문장 속 단어(indexOf(), substring() 사용)
public class String3_1{
    public String solution(String str){
        String answer = "";
        int pos;

        while ((pos = str.indexOf(' '))!=-1){
            String tmp = str.substring(0, pos);
            if(tmp.length()>answer.length()) answer = tmp;
            str = str.substring(pos+1);
        }
        if(str.length()>answer.length()) answer = str;

        return answer;
    }

    public static void main(String[] args){
        String3_1 T = new String3_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}