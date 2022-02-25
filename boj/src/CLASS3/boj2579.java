package CLASS3;

import java.util.Scanner;

public class boj2579 {

    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stairs = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            stairs[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++){
            if(i<=2){
                dp[i] = dp[i-1] + stairs[i];
            }else{
                dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+ stairs[i-1]+stairs[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
