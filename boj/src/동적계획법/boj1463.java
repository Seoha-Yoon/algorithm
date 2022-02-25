package 동적계획법;

import java.util.Scanner;

public class boj1463 {
    static int N;
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1];

        System.out.println(calculate(N));
    }

    private static int calculate(int n) {
        if(n==1 || n==0) return 0;
        if(n==2 || n==3) return 1;

        if(dp[n]==0){
            if(n%6 == 0){
                dp[n] = Math.min(calculate(n/2)+1, calculate(n-1)+1);
                dp[n] = Math.min(dp[n], calculate(n/3)+1);
            }else if(n%2==0){
                dp[n] = Math.min(calculate(n/2)+1, calculate(n-1)+1);
            }else if(n%3 == 0){
                dp[n] = Math.min(calculate(n/3)+1, calculate(n-1)+1);
            }else{
                dp[n] = calculate(n-1)+1;
            }

        }
        return dp[n];
    }
}
