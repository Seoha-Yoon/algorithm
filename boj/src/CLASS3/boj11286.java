package CLASS3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11286 {

    static class Number implements Comparable<Number>{
        int num;
        int abs;

        public Number(int num) {
            this.num = num;
            abs = Math.abs(num);
        }

        @Override
        public int compareTo(Number number) {
            if(number.abs == this.abs) return this.num - number.num;
            return this.abs - number.abs;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            Number number = new Number(n);

            if(n==0){
                if(pq.isEmpty()) res.add(0);
                else res.add(pq.poll().num);
            }else{
                pq.add(number);
            }
        }

        for (Integer r : res) {
            System.out.println(r);
        }
    }
}
