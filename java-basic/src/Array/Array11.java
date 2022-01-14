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

// runtime error 발생, 오답
public class Array11 {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int max = 0; // 겹치는 학생 수의 최대값
        int friends;

        for(int i=0; i<n;i++){
            // n+1 번 학생의 반
            int[] c_num = arr[i];
            // n+1 번 학생과 겹치는 학생 수
            friends = 0;

            for(int j=0; j<n; j++){
                // 자기 자신 제외
                if(i!=j){
                    // 1학년, 2학년, 3학년, 4학년, 5학년
                    if(c_num[0] == arr[j][0]) friends++;
                    if(c_num[1] == arr[j][1]) friends++;
                    if(c_num[2] == arr[j][2]) friends++;
                    if(c_num[3] == arr[j][3]) friends++;
                    if(c_num[4] == arr[j][4]) friends++;
                }
            }

            if(max<friends){
                answer = i+1;
                max = friends;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array11 T = new Array11();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<5; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, arr));
    }
}