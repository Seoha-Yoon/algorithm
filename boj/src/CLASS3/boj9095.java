package CLASS3;

import java.util.Scanner;

public class boj9095 {

    static int n, cnt;
    static int[] arr = {1, 2, 3};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] res = new int[T];

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            cnt = 0;
            numOfMethods(0, 0);
            res[i] = cnt;
        }

        for (int re : res) {
            System.out.println(re);
        }


    }

    private static void numOfMethods(int c, int val) {
        if (val == n){
            cnt++;
            return;
        }

        if (val > n) return;

        for (int i = 0; i < 3; i++) {
            val += arr[i];
            numOfMethods(i, val);
            val -= arr[i];
        }
    }
}
