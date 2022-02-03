package DAY11;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// Max Heap. Min Heap 이용해서 중간값 구하기
public class Prob34 {
    static int N, A;

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY11/input34.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt(); // 3
            A = sc.nextInt(); // 5
            int sum = 0;

            // max heap
            PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
            // min heap
            PriorityQueue<Integer> bigger = new PriorityQueue<>();

            int mid = A;
            for(int i=1; i<=N; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                // mid 보다 크면,
                if(mid>a) smaller.add(a);
                else bigger.add(a);
                if(mid>b) smaller.add(b);
                else bigger.add(b);

                while (smaller.size()>bigger.size()){
                    bigger.add(mid);
                    mid = smaller.poll();
                }

                while (smaller.size()<bigger.size()){
                    smaller.add(mid);
                    mid = bigger.poll();
                }

                sum += (sum+mid)%20171109;
            }

            System.out.println("#"+test_case+" "+sum);

        }
    }
}
