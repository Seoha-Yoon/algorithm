package Array;

import java.util.Scanner;

// 5. 소수(에라토스테네스 체)
/*
20

8
 */
public class Array5_1 {
    public int solution(int n){
        int answer = 0;
        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i] == 0){
                answer++;
                // ch[i]의 배수들 다 지우기
                for (int j=i; j<=n; j+=i) ch[j]=1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Array5_1 T = new Array5_1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        System.out.print(T.solution(n));
    }
}