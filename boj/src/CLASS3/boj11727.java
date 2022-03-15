package CLASS3;

import java.util.Scanner;

public class boj11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];

        if(N==1) {
            System.out.println(1);
            return;
        }else if(N==2){
            System.out.println(3);
            return;
        }else{
            arr[1] = 1;
            arr[2] = 3;
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i-1]+arr[i-2]*2)%10007;
            }
        }
        System.out.println(arr[N]);
    }
}
