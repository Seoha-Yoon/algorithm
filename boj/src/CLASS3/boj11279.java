package CLASS3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();

            if(n==0){
                if(pq.isEmpty()) res.add(0);
                else res.add(pq.poll());
            }else{
                pq.add(n);
            }
        }

        for (Integer r : res) {
            System.out.println(r);
        }
    }
}
