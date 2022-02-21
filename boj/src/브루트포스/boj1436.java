package 브루트포스;

import java.util.Scanner;

public class boj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String bye = "666";
        int cnt = 0;
        for(int i=666; i<=10000666; i++){
            String str = Integer.toString(i);
            if(str.contains(bye)) cnt++;
            if(cnt == N){
                System.out.println(i);
                return;
            }
        }
    }
}
