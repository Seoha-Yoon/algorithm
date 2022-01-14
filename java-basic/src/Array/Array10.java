package Array;
import java.util.Scanner;

// 10. 봉우리
/*
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

10
 */

public class Array10 {
    public int solution(int n, int[][] arr){
        int answer = 0;

        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                int center = arr[i][j];

                //상
                if(j!= 0 && arr[i][j-1]>=center) continue;
                //하
                if(j!=n-1 && arr[i][j+1]>=center) continue;
                //좌
                if(i!=0 && arr[i-1][j]>=center) continue;
                //우
                if(i!=n-1 && arr[i+1][j]>=center) continue;

                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array10 T = new Array10();
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