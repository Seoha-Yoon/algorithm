package CLASS3;

import java.util.Scanner;

public class boj1107 {

    static int N, M, closeNum;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<M; i++){
            int n = sc.nextInt();
            broken[n] = true;
        }

        System.out.println(count());
    }

    private static int count() {
        int len = Integer.toString(N).length();
        findClose(len-1);
        findClose(len);
        findClose(len+1);
        return Math.abs(closeNum-N);
    }

    private static void findClose(int len) {

    }
}
