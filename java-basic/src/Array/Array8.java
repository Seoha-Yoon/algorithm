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

public class Array8 {
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];
        Integer[] score = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(score, Collections.reverseOrder());

        for(int i=0; i<n; i++){
            int s = arr[i];

            if(score[0]==s) answer[i] = 1;

            int prize = 1;
            for(int j=1; j<n; j++){
                prize++;
                if(score[j-1]==score[j]) prize--;
                else prize = j+1;
                if(score[j] == s) answer[i] = prize;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Array8 T = new Array8();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = kb.nextInt();

        for(int i: T.solution(n, arr))
            System.out.print(i+" ");
    }
}