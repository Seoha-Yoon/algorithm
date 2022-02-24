package 동적계획법;

import java.util.Scanner;

public class boj9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] N = new int[T];
        long[] dp = new long[101];

        for(int i=0; i<T; i++){
            N[i] = sc.nextInt();
        }

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=100; i++){
            dp[i] = dp[i-3] + dp[i-2];
        }

        for(int i=0; i<T; i++){
            System.out.println(dp[N[i]]);
        }

    }
}
