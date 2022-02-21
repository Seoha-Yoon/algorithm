package 재귀;

import java.util.Scanner;

public class boj10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(fib(N));
    }

    private static int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        return fib(n-1)+fib(n-2);
    }
}
