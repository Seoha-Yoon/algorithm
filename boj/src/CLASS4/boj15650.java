package CLASS4;

import java.util.Scanner;

// bit masking 이용한 조합
public class boj15650 {

    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        String str ="";
        permutation(0, 0, str, 0);

    }

    private static void permutation(int cnt, int used, String result, int before) {
        if(cnt == M){
            System.out.println(result);
            return;
        }

        for (int i = 0; i <N; i++) {
            if((used & (1<<i))!=0) continue;
            int n = i+1;
            if(before < n){
                permutation(cnt+1, used | (1<<i), result+n+" ", n );
            }
        }
    }
}
