package CLASS3;

import java.util.Scanner;

public class boj11047 {

    static int minCnt, K, N;
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        coin  = new int[N];
        int s = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            s = i;
            // K 가치보다 동전의 가치가 더 크다면 고려X
            if(value > K && !flag){
                s = i-1;
                flag = true;
            }
            coin[i] = value;
        }

        minCnt = Integer.MAX_VALUE;
        findMinCnt(s, K, 0);
        System.out.println(minCnt);
    }

    private static void findMinCnt(int pos, int val, int cnt) {
        if(val == 0) minCnt = Math.min(minCnt, cnt);
        if(val < 0 ) return;
        if(pos < 0) return;

        int tmpVal = val%coin[pos];
        int tmpCnt = cnt + val/coin[pos];

        findMinCnt(pos-1, tmpVal, tmpCnt);
        findMinCnt(pos-1, val, cnt);
    }
}
