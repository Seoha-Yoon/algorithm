package 동적계획법;

import java.util.ArrayList;
import java.util.Scanner;

public class boj9184 {
    static class Answer{
        int a, b, c, answer;

        public Answer(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int a, b, c;
    static int[][][] dp;
    static boolean[][][] checked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = 0;
        b = 0;
        c = 0;

        ArrayList<Answer> ans = new ArrayList<>();

        dp = new int[21][21][21];
        checked = new boolean[21][21][21];
        while (true){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a == -1 && b ==-1 && c ==-1) break;
            Answer an = new Answer(a, b, c);
            an.answer = w(a,b,c);
            ans.add(an);
        }

        for (Answer an: ans){
            System.out.println("w("+an.a+", "+an.b+", "+an.c+") = "+an.answer);
        }
    }

    private static int w(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return w(20,20,20);

        if(checked[a][b][c]){
            return dp[a][b][c];
        }else{
            if(a<b && b<c){
                dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
                checked[a][b][c] = true;
                return dp[a][b][c];
            }else{
                dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
                checked[a][b][c] = true;
                return dp[a][b][c];
            }
        }
    }
}
