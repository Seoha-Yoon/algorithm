package 동적계획법;

import java.util.Scanner;

public class boj1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i][j]+dp[i-1][j-1], dp[i][j]+dp[i-1][j]);
            }
        }

        int max= 0;
        for(int n: dp[N])
            if(max<n) max = n;

        System.out.println(max);
    }
}
