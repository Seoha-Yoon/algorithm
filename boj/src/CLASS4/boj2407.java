package CLASS4;

import java.math.BigInteger;
import java.util.Scanner;

public class boj2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger[][] dp = new BigInteger[101][101];
        dp[1][1] = BigInteger.valueOf(1);
        dp[2][1] = BigInteger.valueOf(2);
        dp[2][2] = BigInteger.valueOf(1);
        for (int i = 3; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if(i == j){
                    dp[i][j] = BigInteger.valueOf(1);
                }else if(j==1) {
                    dp[i][j] = BigInteger.valueOf(i);
                }else{
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }
        if(m > 2/n) m = n-m;
        System.out.println(dp[n][m]);
    }
}
