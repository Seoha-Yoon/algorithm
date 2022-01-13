package String;

import java.util.Scanner;

// 5. 특정 문자 뒤집기 (Character.isAlphabetic() 사용)
/*
a#b!GE*T@S

S#T!EG*b@a
 */
public class String5_1 {
    public String solution(String str){
        String answer = "";
        char[] arr = str.toCharArray();
        int lt =0, rt = arr.length-1;

        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else{
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(arr);
        return answer;
    }

    public static void main(String[] args){
        String5_1 T = new String5_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}