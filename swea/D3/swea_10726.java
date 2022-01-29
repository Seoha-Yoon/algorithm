package DAY1;

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

class Prob3
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY1/input3.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            int len = s.length();
            int res = 0;

            // i 일차에 출근한 인원구성이 j인 경우의 수
            int[][] dp = new int[len+1][16];

            // 첫째날은 A가 무조건 있어야함 A = 0b1;
            for(int i=1; i<(1<<4); i++){
                if((i&1)==1 && (i&changeA2N(s.charAt(0)))!=0) dp[1][i]++;
            }

            for(int i=2; i<=len; i++){
                int r = changeA2N(s.charAt(i-1));

                for(int j=1; j<(1<<4); j++){
                    // 오늘의 책임자가 무조건 있어야함.
                    if((j & r) != 0){
                        // 어제 동방에 있던 사람 중 겹치는 사람이 있어야함.
                        for(int k=1; k<(1<<4); k++){
                            int yesterday = dp[i-1][k];
                            if(yesterday!=0 && (j & k) !=0 ){
                                dp[i][j] = (dp[i][j] + dp[i-1][k])%1000000007;
                            }
                        }
                    }
                }
            }

            for(int n: dp[len])
                res = (res+n)%1000000007;

            System.out.println("#"+test_case+" "+res);
        }
    }

    public static int changeA2N(char r){
        // ABCD 처리
        switch (r){
            case 'A':
                return 0b1;
            case 'B':
                return 0b10;
            case 'C':
                return 0b100;
            case 'D':
                return 0b1000;
        }
        return 0;
    }
}