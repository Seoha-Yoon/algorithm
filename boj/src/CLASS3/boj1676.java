package CLASS3;

import java.util.Scanner;

public class boj1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] zeros = new int[501];
        int[] twos = new int[501];
        int[] fives = new int[501];

        twos[0] = 0;
        fives[0] = 0;

        for(int i=1; i<=500; i++){
            if( i % 10 == 0 ){
                twos[i] = twos[i-1] + divide(i, 2);
                fives[i] = fives[i-1] + divide(i, 5);
            }else if( i % 2 == 0 ){
                twos[i] = twos[i-1] + divide(i, 2);
                fives[i] = fives[i-1];
            }else if( i % 5 == 0 ){
                fives[i] = fives[i-1] + divide(i, 5);
                twos[i] = twos[i-1];
            }else{
                twos[i] = twos[i-1];
                fives[i] = fives[i-1];
            }
            
        }

        for(int i=0; i<=500; i++){
            zeros[i] = Math.min(twos[i], fives[i]);
        }

        System.out.println(zeros[N]);
    }

    static public int divide(int n, int div){
        int cnt = 0;
        while (n % div == 0){
            n /= div;
            cnt++;
        }
        return cnt;
    }
}
