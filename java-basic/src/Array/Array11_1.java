package Array;
import java.util.Scanner;

// 11. 임시반장 정하기
/*
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

4
 */

public class Array11_1 {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int max = 0; // 겹치는 학생 수의 최대값
        int friends;

        for(int i=1; i<=n;i++){
            // n+1 번 학생과 겹치는 학생 수
            friends = 0;
            for(int j=1; j<=n; j++){
                for(int k=1; k<=5; k++){
                    if(arr[i][k] == arr[j][k]){
                        friends++;
                        break;
                    }
                }
            }

            if(max<friends){
                answer = i;
                max = friends;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array11_1 T = new Array11_1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n+1][6];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=5; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, arr));
    }
}