package DAY3;

import java.io.FileInputStream;
import java.util.Scanner;

// 제한시간초과, 조합 말고 DP로 풀어보기
public class Prob12 {
    public static void main(String args[]) throws Exception
    {
		System.setIn(new FileInputStream("src/DAY3/input12.txt"));


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(); // 물건의 개수
            int K = sc.nextInt(); // 가방의 부피

            int[] size = new int[N+1];
            int[] value = new int[N+1];

            for(int i=1; i<=N; i++){
                size[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }

            int[][] dp = new int[N+1][K+1];

            for(int i=1; i<=N; i++){
                for(int j=0; j<=K; j++){
                    // 배낭에 넣지 못할 때,
                    if(size[i]>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        /*
                         배낭에 넣을 수 있을 때,
                         (1) 이 물건을 배낭에 넣지 않았을 때의 value: dp[i-1][j]
                         (2) 이 물건을 배낭에 넣었을 때의 value: dp[i-1][j-size[i]]+value[i]
                         중 max 값을 dp 배열에 넣음
                         */
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-size[i]]+value[i]);
                    }
                }
            }
            System.out.println("#"+test_case+" "+dp[N][K]);
        }
    }

}
