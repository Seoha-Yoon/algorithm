package String;

import java.util.ArrayList;
import java.util.Scanner;

// 10. 가장 짧은 문자거리 (indexOf 이용)
/*
teachermode e

1 0 1 2 1 0 1 2 2 1 0
 */
public class String10 {
    public ArrayList<Integer> solution(String str, char c){
        ArrayList<Integer> answer = new ArrayList<>();
        int index = str.indexOf(c); // 이전 인덱스

        for(int i=0; i<str.length(); i++){
            int cur_index = str.indexOf(c,i);

            if(Math.abs(i-index)>=Math.abs(i-cur_index)){
                index = cur_index;
                answer.add(Math.abs(i-cur_index));
            }else{
                answer.add(Math.abs(i-index));
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String10 T = new String10();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기
        char c = kb.next().charAt(0);

        for(int i: T.solution(str, c))
            System.out.print(i+" ");
    }
}