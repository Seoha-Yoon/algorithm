package CLASS4;

import java.util.Arrays;
import java.util.Scanner;

public class boj15657 {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        String str ="";
        permutation(0,str,0);

    }

    private static void permutation(int cnt, String result, int before) {
        if(cnt == M){
            System.out.println(result);
            return;
        }

        for (int i = 0; i <N; i++) {
            if(arr[i]>=before)
                permutation(cnt+1, result+arr[i]+" ", arr[i]);
        }
    }
}
