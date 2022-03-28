package CLASS4;

import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class boj1967 {
    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static int max_node = 0, max_sum = 0;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, c));
            graph[n2].add(new Node(n1, c));
        }

        visited = new boolean[n+1];
        // 임의의 노드에서 가장 먼 노드 구하기
        dfs(1, 0);
        visited = new boolean[n+1];
        // 가장 먼 노드에서의 가장 먼 거리 구하기
        dfs(max_node, 0);

        bw.write(Integer.toString(max_sum));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int sum){
        if(max_sum <= sum){
            max_sum = sum;
            max_node = n;
        }

        if(!visited[n]){
            visited[n] = true;
            for (Node next: graph[n]){
                if(!visited[next.idx]){
                    dfs(next.idx, sum+next.cost);
                }
            }
        }
    }
}
