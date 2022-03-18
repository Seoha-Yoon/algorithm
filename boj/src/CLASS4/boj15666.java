package CLASS4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class boj15666 {
    static int N, M;
    static int[] arr;
    static HashSet<String> set;
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
        set = new HashSet<>();
        permutation(0,str,0);

    }

    private static void permutation(int cnt, String result, int before) {
        if(cnt == M){
            if(set.isEmpty() || !set.contains(result))
                System.out.println(result);
            set.add(result);
            return;
        }

        for (int i = 0; i <N; i++) {
            if(arr[i]>=before)
                permutation(cnt+1, result+arr[i]+" ", arr[i]);
        }
    }
}

