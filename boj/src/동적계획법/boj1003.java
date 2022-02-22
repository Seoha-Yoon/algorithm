package 동적계획법;

import java.util.Scanner;

public class boj1003 {

    static int[][] fib;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        fib = new int[41][2];
        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        for (int i=2; i<41; i++){
            fib[i][0] = fib[i-1][0]+fib[i-2][0];
            fib[i][1] = fib[i-1][1]+fib[i-2][1];
        }

        int[] N = new int[T];
        for (int i=0; i<T; i++){
            N[i] = sc.nextInt();
        }

        for (int i=0; i<T; i++){
            System.out.println(fib[N[i]][0]+" "+fib[N[i]][1]);
        }
    }
}
