package Array;

import java.util.ArrayList;
import java.util.Scanner;

// 6. 뒤집은 소수
/*
9
32 55 62 20 250 370 200 30 100

23 2 73 2 3
 */

public class Array6 {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder(Integer.toString(arr[i]));
            int reverse = Integer.parseInt(sb.reverse().toString());

            if(isPrime(reverse)) answer.add(reverse);
        }

        return answer;
    }

    private boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Array6 T = new Array6();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = kb.nextInt();

        for(int i: T.solution(n, arr))
            System.out.print(i+" ");
    }
}