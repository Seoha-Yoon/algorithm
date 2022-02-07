package DAY12;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prob35 {

    static int N, K;
    static int A[];

    static class Divide implements Comparable<Divide>{
        int q, r;

        public Divide(int q, int r) {
            this.q = q; // 몫
            this.r = r; // 나머지
        }

        @Override
        public int compareTo(Divide d) {
            if(this.r == d.r) return this.q - d.q;
            return this.r - d.r;
        }
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY12/input35.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // initialize
            N = sc.nextInt();
            A = new int[N];
            for(int i=0; i<N; i++) A[i] = sc.nextInt();
            K = sc.nextInt();

            /*
                풀이
                ex) 2번 tc
                1. X에 D=1을 1번 더함. X=1, 횟수 1
                2. D에 A 곱하고, X에 D=3을 2번 더함. X=7, 횟수 3
                3. D에 A 곱하고, X에 D=9 1번 더함. X=9, 횟수 4
                K = 1*A^2 + 2*A + 1 = ((1)*A+2)*A + 1 이므로
                K를 A로 계속해서 나누고, 그 나머지를 더하면 됨.
                나머지의 합이 작은 순으로 우선순위를 만들고, 나머지의 합과 몫을 큐에 집어넣으면 된다.
             */

            PriorityQueue<Divide> pq = new PriorityQueue<>();
            pq.add(new Divide(K,0));
            while (!pq.isEmpty()){
                if(pq.peek().q == 0) break;
                Divide div = pq.poll();

                int r = div.r;
                int q= div.q;

                // 일단 K를 A로 나눈 몫과 나머지들의 합을 pq에 넣는다.
                for(int i =0; i<A.length; i++){
                    pq.add(new Divide(q/A[i], r+q%A[i]));
                }
            }

            System.out.println("#"+test_case+" "+pq.peek().r);
        }
    }
}
