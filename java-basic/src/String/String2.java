import java.util.Scanner;

// 2. 대소문자 변환
public class String2 {
    public String solution(String str){
        String answer = "";

        for(char c: str.toCharArray()){
            if(Character.isLowerCase(c)) answer+=Character.toUpperCase(c);
            else answer+=Character.toLowerCase(c);
        }

        return answer;
    }

    public static void main(String[] args){
        String2 T = new String2();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}