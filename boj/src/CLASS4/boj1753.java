package CLASS4;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
    static int V, E, K;
    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V =Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }

        dist = new int[V+1];
        for (int i=1; i<=V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                bw.append("INF\n");
            else bw.append(dist[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(n, 0));
        dist[n] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.cost) continue;
            for (Node next: graph[cur.idx]){
                if(dist[next.idx] > cur.cost + next.cost){
                    dist[next.idx] = cur.cost + next.cost;
                    pq.add(new Node(next.idx , dist[next.idx]));
                }
            }
        }
    }
}
