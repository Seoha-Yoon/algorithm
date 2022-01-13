package String;

import java.util.Scanner;

// 3. 문장 속 단어(split)사용
public class String3 {
    public String solution(String str){
        String answer = "";

        String[] sp = str.split(" ");

        for(int i=0; i<sp.length; i++){
            if(sp[i].length() > answer.length()) answer = sp[i];
        }

        return answer;
    }

    public static void main(String[] args){
        String3 T = new String3();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}