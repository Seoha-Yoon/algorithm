package CLASS4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1238 {

    static int N, M, X;

    static class Edge{
        int idx; // 다음 노드
        int cost; // 비용

        public Edge(int dest, int cost) {
            this.idx = dest;
            this.cost = cost;
        }
    }

    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, c));
        }

        int result = 0;
        // 다익스트라 ? -> X
        // 다익스트라 X -> ?
        for (int i = 1; i <= N; i++) {
            if(i==X) continue;
            int c1 = dijkstra(i, X);
            int c2 = dijkstra(X, i);
            int c = c1+ c2;
            result = Math.max(c, result);
        }

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int n1, int n2) {
        // 다익스트라 알고리즘 초기화
        int[] dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Edge(n1, 0));
        dist[n1] = 0;
        while (!pq.isEmpty()){
            Edge curEdge = pq.poll();
            if (dist[curEdge.idx] < curEdge.cost) continue;

            for (Edge e : graph[curEdge.idx]) {
                if(dist[e.idx] > curEdge.cost + e.cost){
                    dist[e.idx] = curEdge.cost + e.cost;
                    pq.add(new Edge(e.idx, dist[e.idx]));
                }
            }
        }
        return dist[n2];
    }
}
