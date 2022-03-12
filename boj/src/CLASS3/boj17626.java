package CLASS3;

import java.util.Scanner;

public class boj17626 {
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        count = new int[N+1];
        count[1] = 1;
        int minCnt;
        for (int i = 2; i <= N; i++) {
            minCnt = Integer.MAX_VALUE;

            for (int j=1; j*j<=i; j++){
                minCnt = Math.min(minCnt, count[i-j*j]);
            }
            count[i] = minCnt+1;
        }

        System.out.println(count[N]);
    }


}
