package 브루트포스;

import java.util.Scanner;

public class boj2798 {
    static int[] cards;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N];

        for(int i=0; i<N; i++)
            cards[i] = sc.nextInt();

        System.out.println(maxSum(0, 0, 0));
    }

    static int maxSum(int cnt, int used, int val){
        if(cnt == 3) return val;

        int max = 0;
        for (int i=0; i<N; i++){
            if((used & (1<<i))!= 0) continue;
            int res = maxSum(cnt+1, used|(1<<i),val+cards[i]);
            if(res>max && res<=M) max = res;
        }
        return max;
    }
}
