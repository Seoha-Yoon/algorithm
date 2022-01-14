package Array;
import java.util.ArrayList;
import java.util.Scanner;

// 1. 큰 수 출력하기
/*
6
7 3 9 5 6 12

7 9 6 12
 */
public class Array1 {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        // 첫 수 무조건 출력
        answer.add(arr[0]);

        for(int i=1; i<n; i++){
            if(arr[i-1]<arr[i]) answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        Array1 T = new Array1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        for(int a: T.solution(n, arr))
            System.out.print(a+" ");
    }
}