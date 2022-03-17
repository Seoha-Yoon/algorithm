package CLASS4;

import java.util.Scanner;

public class boj15652 {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        String str ="";
        permutation(0, str, 0);

    }

    private static void permutation(int cnt, String result, int before) {
        if(cnt == M){
            System.out.println(result);
            return;
        }

        for (int i = 0; i <N; i++) {
            int n = i+1;
            if(before <= n){
                permutation(cnt+1, result+n+" ", n );
            }
        }
    }
}
