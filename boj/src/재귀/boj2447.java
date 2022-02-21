package 재귀;

import java.util.Arrays;
import java.util.Scanner;

public class boj2447 {
    static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        star = new char[N][N];
        for(int i=0; i<N; i++)
            Arrays.fill(star[i], ' ');

        draw(N, 0, 0);

        for(int i=0; i<N; i++)
            System.out.println(star[i]);

    }

    private static void draw(int n, int x, int y) {
        if(n==1){
            star[x][y] = '*';
            return;
        }

        int cnt = 0;

        for (int i=x; i<n+x; i+=n/3){
            for(int j=y; j<n+y; j+=n/3){
                if(cnt == 4) cnt = 0;
                else{
                    draw(n/3, i, j);
                    cnt++;
                }
            }
        }
    }

}
