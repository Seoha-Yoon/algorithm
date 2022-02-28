package CLASS3;

import java.util.Scanner;

public class boj1074 {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        cnt= 0;
        sol(N, r, c);
        System.out.println(cnt);
    }

    private static void sol(int n, int r, int c) {

        if(n==0) return;

        int k = (int)Math.pow(2,n)/2;

        if(r<k && c>=k){
            cnt += k*k;
            sol(n-1, r, c-k);
        }else if(r>=k && c<k){
            cnt += k*k*2;
            sol(n-1, r-k, c);
        }else if(r>=k && c>=k){
            cnt += k*k*3;
            sol(n-1, r-k, c-k);
        }else{
            sol(n-1, r, c);
        }

    }

}
