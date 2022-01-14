package Array;

import java.util.Scanner;

// 4. 피보나치수열
/*
10

1 1 2 3 5 8 13 21 34 55
 */

public class Array4 {
    public int[] solution(int n){
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for(int i=2; i<n; i++){
            answer[i] = answer[i-1]+answer[i-2];
        }

        return answer;
    }

    public static void main(String[] args){
        Array4 T = new Array4();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        for (int i: T.solution(n))
            System.out.print(i+" ");
    }
}