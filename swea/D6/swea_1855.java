package DAY6;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// LCA 알고리즘으로 풀기
// fail tc 61개 중 59개 맞음 -> 범위 문제! 다른 문제 풀때도 범위 잘 확인하기 별별
// 연결행렬 -> 연결리스트로 바꿔보기
public class Prob21 {

    static int[][] parent;
    static int N;
    static int[] dist;
    static ArrayList<Integer> arr;
    static ArrayList<Integer>[] child;
    static final int MAX_DEPTH = 18; // -> 왜 18개?

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY6/input21.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            child = new ArrayList[N+1];
            for(int i=0; i<child.length; i++)
                child[i] = new ArrayList<>();

            dist = new int[N+1];
            arr = new ArrayList<>();

            // Sparse Table
            parent = new int[N+1][MAX_DEPTH+1];

            for(int i=2; i<=N; i++){
                int p = sc.nextInt();
                child[p].add(i);
            }

            bfs();
            connect();

            // 범위초과 -> TC 2개
            long res = 0;
            for(int i=0; i<arr.size()-1; i++){
                int node1 = arr.get(i);
                int node2 = arr.get(i+1);
                int lca = LCA(node1, node2);
                res+=(dist[node1]-dist[lca]+dist[node2]-dist[lca]);
            }

            System.out.println("#"+test_case+" "+res);

        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        // 1번 노드부터 탐색 시작
        q.add(1);
        dist[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            arr.add(cur);

            for(Integer next: child[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[cur]+1;
                    // 바로 위 부모 노드 저장
                    parent[next][0] = cur;
                    q.add(next);
                }
            }
        }
    }

    // 각자 n 번째 부모 연결
    private static void connect(){
        for (int p=1; p<=MAX_DEPTH; p++){
            for(int cur =1; cur<=N; cur++)
                parent[cur][p] = parent[parent[cur][p-1]][p-1];
        }
    }

    // 최소 공통 조상 찾기
    private static int LCA(int node1, int node2){
        // 깊이 더 높은 node = node2
        if(dist[node1]>dist[node2]){
            int tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        // 높이 맞추기
        for(int i = MAX_DEPTH; i>=0; i--)
            if(dist[parent[node2][i]] >= dist[node1]) node2 = parent[node2][i];

        if(node1 == node2) return node1;

        for(int i = MAX_DEPTH; i>=0; i--){
            if(parent[node1][i] != parent[node2][i]){
                node1 = parent[node1][i];
                node2 = parent[node2][i];
            }
        }
        return parent[node1][0];
    }

}
