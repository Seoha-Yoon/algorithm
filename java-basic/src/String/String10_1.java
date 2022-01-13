package String;

import java.util.Scanner;

// 10. 가장 짧은 문자거리 (p를 1000으로 설정해서 왼쪽, 오른쪽 비교)
/*
teachermode e

1 0 1 2 1 0 1 2 2 1 0
 */
public class String10_1 {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];

        int p = 1000;
        // 왼쪽 e 기준으로 탐색 시작
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == c){
                p = 0;
                answer[i] = p;
            }else{
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        // 오른쪽 e 기준으로 탐색하면서 최솟값 저장
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c) p = 0;
            else{
                p++;
                answer[i] = Math.min(answer[i],p );
            }
        }


        return answer;
    }

    public static void main(String[] args){
        String10_1 T = new String10_1();
        Scanner kb = new Scanner(System.in);

        String str = kb.next(); // 문자열 읽기
        char c = kb.next().charAt(0);

        for(int i: T.solution(str, c))
            System.out.print(i+" ");
    }
}