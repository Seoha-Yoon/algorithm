package 재귀;

import java.util.Scanner;

public class boj11729 {
    static int cnt;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cnt = 0;
        sb = new StringBuilder();
        play(N, 1,3,2);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void play(int n, int start, int des, int tmp) {
        if(n==1){
            cnt++;
            sb.append(start+" "+des+"\n");
            return;
        }

        // 가장 큰 원판을 제외한 나머지 N-1개 원판을 다른 장대에 옮긴다.
        play(n-1, start, tmp, des);
        // 가장 큰 원판을 목적지에 옮긴다.
        sb.append(start+" "+des+"\n");
        cnt++;
        // 나머지 n-1개 원판을 목적지로 옮긴다.
        play(n-1, tmp, des, start);
    }
}
