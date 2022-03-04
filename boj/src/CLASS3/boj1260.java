package CLASS3;

import java.util.*;

// BFS, DFS
public class boj1260 {
    static int N, M, V;
    static boolean map[][]; // 간선 정보 저장

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        map = new boolean[N+1][N+1];

        for(int i=0; i<M; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            map[n][m] = true;
            map[m][n] = true;
        }

        ArrayList<Integer> arr1 = dfs();
        ArrayList<Integer> arr2 = bfs();

        for (Integer i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (Integer i : arr2) {
            System.out.print(i+" ");
        }
    }

    private static ArrayList<Integer> bfs() {
        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(V);
        visited[V] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for(int i=1; i<=N; i++){
                if(map[cur][i] && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return res;
    }

    private static ArrayList<Integer> dfs() {
        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();

        stk.push(V);

        while (!stk.isEmpty()){
            int cur = stk.pop();

            if(!visited[cur]){
                visited[cur] = true;
                res.add(cur);
                for(int i=N; i>=1; i--){
                    if(map[cur][i] && !visited[i]){
                        stk.add(i);
                    }
                }
            }
        }

        return res;
    }
}
