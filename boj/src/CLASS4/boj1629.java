package CLASS4;

import java.util.Scanner;

// 타입, 괄호 주의!!
public class boj1629 {
    static long A, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();
        System.out.println(power(B));
    }

    private static long power(long n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return A%C;
        }
        long temp = power(n/2)%C;
        if(n%2==0) return (temp*temp)%C;
        else return (((temp*temp)%C)*A)%C;
    }
}
