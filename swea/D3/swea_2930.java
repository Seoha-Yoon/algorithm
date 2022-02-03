package DAY11;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

// pq 활용해서 heap 구현해보기
public class Prob32 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY11/input32.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            ArrayList<Integer> arr = new ArrayList<>();

            int N = sc.nextInt();

            for(int i=0; i<N; i++){
                int type = sc.nextInt();

                switch (type){
                    case 1:
                        int num = sc.nextInt();
                        pq.add(num);
                        break;
                    case 2:
                        if(!pq.isEmpty()) arr.add(pq.poll());
                        else arr.add(-1);
                        break;
                }
            }

            System.out.print("#"+test_case+" ");
            for(int n: arr)
                System.out.print(n+" ");
            System.out.println();

        }
    }
}
