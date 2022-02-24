package 동적계획법;

import java.util.Scanner;

public class boj1904 {

    static int N;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[1000100];
        System.out.println(f(N));
    }

    private static int f(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(dp[n]!=0){
            return dp[n];
        }else{
            dp[n] = (f(n-1)+f(n-2))%15746;
            return dp[n];
        }
    }
}
