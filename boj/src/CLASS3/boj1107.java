package CLASS3;

import java.util.Scanner;

public class boj1107 {

    static int N, M, closeNum, distance;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        broken = new boolean[10];

        int cnt = 0;
        closeNum = Integer.MAX_VALUE;
        distance = Math.abs(100-N);
        for(int i=0; i<M; i++){
            int n = sc.nextInt();
            broken[n] = true;
            cnt++;
        }



        if(N == 100) System.out.println(0);
        else{
            if(cnt != 10) count();
            System.out.println(distance);
        }
    }

    private static void count() {
        int len = Integer.toString(N).length();

        findClose(len, new StringBuilder());
        distance = Math.min(distance, Integer.toString(closeNum).length() +  Math.abs(closeNum-N));
        if(len-1 >= 1){
            findClose(len-1, new StringBuilder());
            distance = Math.min(distance, Integer.toString(closeNum).length() +  Math.abs(closeNum-N));
        }
        findClose(len+1, new StringBuilder());
        distance = Math.min(distance, Integer.toString(closeNum).length() +  Math.abs(closeNum-N));
    }

    private static void findClose(int len, StringBuilder sb) {
        if(sb.length() == len){
            int val = Math.abs(Integer.parseInt(sb.toString()));
            int a = Math.abs(closeNum-N);
            int b = Math.abs(val -N);
            closeNum = a < b ? closeNum: val;
            return;
        }

        for(int i=0; i<=9; i++){
            if(!broken[i]){
                findClose(len, sb.append(i));
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
