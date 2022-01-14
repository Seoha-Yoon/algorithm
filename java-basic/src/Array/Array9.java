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

public class Array9 {
    public int solution(int n, int[][] arr){
        int max = 0;
        int sum = 0;

        // 가로
        for(int i=0; i<n; i++){
            sum = 0;
            for(int j=0; j<n; j++){
                sum+=arr[i][j];
            }
            max = Math.max(max, sum);
        }

        // 세로
        for(int i=0; i<n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[j][i];
            }
            max = Math.max(max, sum);
        }

        sum = 0;
        // 대각선
        for(int i=0; i<n; i++){
            sum += arr[i][i];
        }
        max = Math.max(max, sum);

        sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i][n-i-1];
        }
        max = Math.max(max, sum);


        return max;
    }

    public static void main(String[] args){
        Array9 T = new Array9();
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