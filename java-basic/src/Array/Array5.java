package Array;

import java.util.Scanner;

// 5. 소수
/*
20

8
 */
public class Array5 {
    public int solution(int n){
        int answer = 0;

        for(int i=2; i<n; i++){
            boolean isPrime = true;
            if(i==2) {
                answer++;
                continue;
            }

            for(int j=2; j<=Math.sqrt(i); j++){
                if(i % j == 0) isPrime = false;
            }

            if(isPrime) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Array5 T = new Array5();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        System.out.print(T.solution(n));
    }
}