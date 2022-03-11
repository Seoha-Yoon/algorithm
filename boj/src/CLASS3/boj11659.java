package CLASS3;

import java.util.Scanner;

public class boj11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N+1];
        int sum[] = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1]+ arr[i];
        }

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            result[i] = sum[m] - sum[n] + arr[n];
        }

        for (int r : result) {
            System.out.println(r);
        }

    }
}
