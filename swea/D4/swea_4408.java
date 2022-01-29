package DAY4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Prob9 {

    final static int NUM_HALLWAY = 200;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY5/input9.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] hallway = new int[NUM_HALLWAY+1];
            int res = 0;

            for(int i=0; i<N; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();

                // 복도 번호 구하기
                int start_num = start % 2==0 ? start/2 : start/2+1;
                int end_num = end % 2==0 ? end/2 : end/2+1;

                // 출발/도착 숫자가 큰 ->작 작-> 큰 일 수 있음.
                int s = Math.min(start_num, end_num);
                int e = Math.max(start_num, end_num);

                // 겹치는 복도 표시
                for(int j = s; j<=e; j++){
                    hallway[j]++;
                }

                // 겹치는 수가 가장 큰 복도가 단위시간이 됨.
                for (int j=1; j<=NUM_HALLWAY; j++){
                    if(hallway[j]>res) res= hallway[j];
                }
            }

            System.out.println("#"+test_case+" "+res);
        }
    }
}
