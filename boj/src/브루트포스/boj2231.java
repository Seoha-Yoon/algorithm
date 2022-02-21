package 브루트포스;

import java.util.Scanner;

public class boj2231 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 각 수의 분해합을 다 구해버리자. 주어지는 수보다 작은 수가 생성자가 될 것이다.
        for(int i=1; i<=1000000; i++){
            int n=0;
            String str = Integer.toString(i);
            for(int j=0; j<str.length(); j++){
                n+=str.charAt(j)-'0';
            }
            n += i;

            if(n == N){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
