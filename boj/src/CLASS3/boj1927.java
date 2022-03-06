package CLASS3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i <N; i++) {
            int n = sc.nextInt();

            if(n==0){
                if(!pq.isEmpty()) res.add(pq.poll());
                else res.add(0);
            }else{
                pq.add(n);
            }
        }

        for (Integer r : res) {
            System.out.println(r);
        }

    }
}
