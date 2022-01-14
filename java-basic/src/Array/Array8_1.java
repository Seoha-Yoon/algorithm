package Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 8. 등수구하기
/*
5
87 89 92 100 76

4 3 2 1 5
 */

public class Array8_1 {
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            int cnt = 1;
            for (int j=0; j<n; j++){
                if(arr[j]>arr[i]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        Array8_1 T = new Array8_1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = kb.nextInt();

        for(int i: T.solution(n, arr))
            System.out.print(i+" ");
    }
}