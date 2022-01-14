package Array;

import java.util.Scanner;

// 3. 가위 바위 보
/*
5
2 3 3 1 3
1 1 2 2 3

A
B
A
B
D
 */
public class Array3 {
    public char[] solution(int n, int[] arr1, int[] arr2){
        char[] answer = new char[n];

        for(int i =0; i<n; i++){
            int res = rspGame(arr1[i], arr2[i]);
            if(res == 1) answer[i] = 'A';
            else if(res == -1) answer[i] = 'B';
            else answer[i] = 'D';
        }
        return answer;
    }

    // a가 이기면 1, 지면 -1, 비기면 0
    private int rspGame(int a, int b){
        if((a == 2 && b == 1) || (a == 3 && b == 2) || (a == 1 && b == 3))
            return 1;
        else if(a == b)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args){
        Array3 T = new Array3();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++) {
            arr1[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++) {
            arr2[i] = kb.nextInt();
        }

        for (char i: T.solution(n, arr1, arr2))
            System.out.println(i);
    }
}