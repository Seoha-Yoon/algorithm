package Array;

import java.util.ArrayList;
import java.util.Scanner;

// 7. 점수계산
/*
10
1 0 1 1 1 0 0 1 1 0

10
 */

public class Array7 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int score=0;

        for(int i=0; i<n; i++){
            // 정답일 때,
            if(arr[i] == 1){
                score++;
                answer+=score;
            }else{
                score = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Array7 T = new Array7();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = kb.nextInt();

        System.out.print(T.solution(n, arr));
    }
}