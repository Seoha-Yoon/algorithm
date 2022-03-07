package CLASS3;

import java.util.ArrayList;
import java.util.Scanner;

public class boj2606 {
    static int N, M, cnt;
    static class Node{
        int id;
        boolean visited;
        ArrayList<Integer> adjacent;

        public Node(int id) {
            this.id = id;
            visited = false;
            adjacent = new ArrayList<>();
        }
    }
    static Node[] network;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        network = new Node[N+1];

        for(int i=1; i<=N; i++){
            network[i] = new Node(i);
        }

        for(int i=0; i<M; i++){
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            network[c1].adjacent.add(c2);
            network[c2].adjacent.add(c1);
        }

        cnt = 0;
        dfs(1);
        System.out.println(cnt-1);
    }

    private static void dfs(int n) {
        if(!network[n].visited){
            network[n].visited = true;
            cnt++;
            for(int c: network[n].adjacent){
                if(!network[c].visited) dfs(c);
            }
        }
    }
}
