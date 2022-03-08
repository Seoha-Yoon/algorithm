package CLASS3;

import java.util.HashSet;
import java.util.Scanner;

public class boj6064 {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];

        for(int i=0; i<T; i++){
            N = sc.nextInt();
            M = sc.nextInt();

            int limit = lcm(N,M); // 최소공배수
            int x = sc.nextInt();
            int y = sc.nextInt();

            // x 와 y가 각각 N과 M을 넘는 수일 수 없다.
            if(x > N || y > M){
                result[i] = -1;
                break;
            }

            boolean find =false;
            HashSet<Integer> check = new HashSet<>();
            for (int xx = x; xx <= limit; xx += N) {
                check.add(xx);
            }

            for (int yy = y; yy <= limit; yy+=M) {
                if(check.contains(yy)){
                    result[i] = yy;
                    find = true;
                    break;
                }
            }

            if(!find) result[i] = -1;

        }

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

    private static int gcd(int n, int m) {
        if(n%m==0) return m;
        return gcd(m, n%m);
    }
}
