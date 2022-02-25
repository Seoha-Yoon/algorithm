package 동적계획법;

import java.util.Scanner;

public class boj1149 {
    static int[][] cost;
    static int minCost, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        cost = new int[N+1][3];

        for(int i=1; i<=N; i++){
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        minCost = Integer.MAX_VALUE;

        // n번째 집의 색
        calculate(2);

        System.out.println(minCost);
    }

    private static void calculate(int n) {
        for(int i=n; i<=N; i++){
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);

            if(i == N){
                minCost = Math.min(minCost, cost[i][0]);
                minCost = Math.min(minCost, cost[i][1]);
                minCost = Math.min(minCost, cost[i][2]);
            }
        }
    }
}
