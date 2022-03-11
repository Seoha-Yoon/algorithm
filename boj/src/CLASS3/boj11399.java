package CLASS3;

import java.util.Arrays;
import java.util.Scanner;

public class boj11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] sum = new int[N];
        sum[0] = arr[0];
        int result = 0;
        result += sum[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + arr[i];
            result += sum[i];
        }

        System.out.println(result);
    }
}
