package CLASS3;

import java.util.Scanner;

public class boj11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        int[] cnt = new int[1001];

        cnt[1] = 1;
        cnt[2] = 2;

        for (int i = 3; i < 1001; i++) {
            cnt[i] = (cnt[i-1]+cnt[i-2])%10007;
        }

        System.out.println(cnt[N]);
    }
}
