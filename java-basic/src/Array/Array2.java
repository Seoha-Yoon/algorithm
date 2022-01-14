package Array;
import java.util.Scanner;

// 2. 보이는 학생
/*
8
130 135 148 140 145 150 150 153

5
 */
public class Array2 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int max = 0;

        for(int a: arr){
            if(a>max) {
                answer++;
                max = a;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array2 T = new Array2();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}