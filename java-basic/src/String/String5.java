package String;

import java.util.Scanner;

// 5. 특정 문자 뒤집기
/*
a#b!GE*T@S
S#T!EG*b@a
 */
public class String5 {
    public String solution(String str){
        String answer = "";
        char[] arr = str.toCharArray();
        int lt =0, rt = arr.length-1;

        while(lt<rt){
            if(checkAlphabet(arr[lt])){
                if(checkAlphabet(arr[rt])){
                    char tmp = arr[lt];
                    arr[lt] = arr[rt];
                    arr[rt] = tmp;
                    lt++;
                    rt--;
                }else{
                    rt--;
                }
            }else{
                lt++;
            }
        }

        answer = String.valueOf(arr);
        return answer;
    }

    private boolean checkAlphabet(char c){
        return (c>=65 && c<=90)||(c>=97 && c<=122);
    }

    public static void main(String[] args){
        String5 T = new String5();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기

        System.out.print(T.solution(str));
    }
}