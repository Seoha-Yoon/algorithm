package CLASS4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 타입 주의!!! -> 안 맞는다 싶을 땐 오버플로우 고려해보기
public class boj1504 {
    static int N, M, v1, v2;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, c));
            graph[n2].add(new Node(n1, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int dv = dijkstra(v1, v2);
        long c1 = (long)dijkstra(1, v1) + (long)dijkstra(v2, N);
        long c2 = (long)dijkstra(1, v2) + (long)dijkstra(v1, N);

        long res;
        long cost1 = (long)dv + c1;
        long cost2 = (long)dv + c2;
        res = Math.min(cost1, cost2);

        if(res % Integer.MAX_VALUE == 0) res = -1;

        bw.write(Long.toString(res));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int n1, int n2) {
        int[] dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[n1] = 0;
        pq.add(new Node(n1, dist[n1]));

        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            if(dist[curNode.idx] < curNode.cost) continue;
            for (Node n: graph[curNode.idx]){
                if(dist[n.idx] > curNode.cost + n.cost ){
                    dist[n.idx] = curNode.cost + n.cost;
                    pq.add(new Node(n.idx, dist[n.idx]));
                }
            }
        }
        return dist[n2];
    }
}
