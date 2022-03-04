package CLASS3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 그래프
public class boj1697 {

    static class Node{
        int id;
        ArrayList<Integer> adjacent;

        public Node(int id) {
            this.id = id;
            adjacent = new ArrayList<>();
        }
    }

    static Node[] nodes = new Node[100001];
    static int[] time;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        nodes = new Node[100001];
        time = new int[100001];

        // graph 간선 연결
        for(int i=0; i<=100000; i++){
            nodes[i] = new Node(i);
            if(i==0){
                nodes[i].adjacent.add(i+1);
            }else if(i==100000){
                nodes[i].adjacent.add(i-1);
            }else{
                nodes[i].adjacent.add(i+1);
                nodes[i].adjacent.add(i-1);
                if(i*2<=100000) nodes[i].adjacent.add(2*i);
            }
        }

        findMin(N, M);
        System.out.println(time[M]);
    }

    private static void findMin(int n, int m) {
        boolean[] visited = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();

        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur==m) return;
            for(int i: nodes[cur].adjacent){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    time[i] = time[cur] +1;
                }
            }
        }
    }
}
