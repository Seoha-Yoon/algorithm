package CLASS4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class boj15663 {
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
        permutation(0,0, str);

    }

    private static void permutation(int cnt, int used, String result) {
        if(cnt == M){
            if(set.isEmpty() || !set.contains(result))
                System.out.println(result);
            set.add(result);
            return;
        }

        for (int i = 0; i <N; i++) {
            if ((used & (1<<i))!=0) continue;
            permutation(cnt+1,used | (1<<i), result+arr[i]+" ");
        }
    }
}
