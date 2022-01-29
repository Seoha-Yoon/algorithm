package DAY8;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

// LCA
public class Prob29 {

    static int V, E, size;
    static int[][] parent;
    static int[] depth;
    static final int MAX_DEPTH = 18;
    static ArrayList<Integer>[] child;
    static boolean[] visited;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY8/input29.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            V = sc.nextInt();
            E = sc.nextInt();
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            visited = new boolean[V+1];
            depth = new int[V+1];

            // sparse table
            parent = new int[V+1][MAX_DEPTH+1];

            // 연결 리스트 초기화
            child = new ArrayList[V+1];
            for(int i=1; i<=V; i++)
                child[i] = new ArrayList<>();

            // 연결 리스트에 자식 추가
            for(int i=0; i<E; i++){
                int p = sc.nextInt();
                int c = sc.nextInt();
                child[p].add(c);
            }

            dfs(1);
            connect(); // sparse table 연결

            int lca = LCA(node1,node2);

            size = 0;
            findSize(lca);

            System.out.println("#"+test_case+" "+lca+" "+size);
        }
    }

    private static void findSize(int node) {
        size++;
        for(Integer c: child[node]){
            findSize(c);
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for(Integer next: child[cur])
            if(!visited[next]){
                // next의 부모가 cur
                parent[next][0] = cur;
                depth[next] = depth[cur]+1;
                dfs(next);
            }
    }

    private static void connect() {
        for(int p=1; p<=MAX_DEPTH; p++)
            for(int cur=1; cur<=V; cur++)
                parent[cur][p] = parent[parent[cur][p-1]][p-1];
    }

    private static int LCA(int node1, int node2){
        // 깊이 더 높은 node = node2
        if(depth[node1] > depth[node2]){
            int tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        // 높이 맞추기
        for(int i = MAX_DEPTH; i>=0; i--)
            if(depth[parent[node2][i]] >= depth[node1]) node2 = parent[node2][i];

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
