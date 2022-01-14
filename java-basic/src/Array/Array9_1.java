package Array;
import java.util.Scanner;

// 9. 격자판 최대 합
/*
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

155
 */

public class Array9_1 {
    public int solution(int n, int[][] arr){
        int max = 0;
        int sum1, sum2;

        for(int i=0; i<n; i++){
            sum1 = sum2 = 0;
            for(int j=0; j<n; j++){
                sum1+=arr[i][j]; // 가로
                sum2 += arr[j][i]; // 세로
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        sum1 = sum2 = 0;
        // 대각선
        for(int i=0; i<n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        max = Math.max(max, sum1);
        max = Math.max(max, sum2);


        return max;
    }

    public static void main(String[] args){
        Array9_1 T = new Array9_1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, arr));
    }
}