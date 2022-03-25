package CLASS4;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916 {
    static int N, M;
    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <=N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest  = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.idx] < cur.cost) continue;

            for(Node next: graph[cur.idx]){
                if(dist[next.idx] > cur.cost + next.cost){
                    dist[next.idx] = cur.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        bw.write(Integer.toString(dist[dest]));
        bw.flush();
        bw.close();
        br.close();
    }
}
