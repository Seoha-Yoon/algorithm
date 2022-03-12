package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {

    static class Node{
        int n;
        ArrayList<Integer> adjacent;
        boolean visited;

        public Node(int n) {
            this.n = n;
            adjacent = new ArrayList<>();
            visited =false;
        }
    }

    static Node[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];
        for (int i = 1; i <=N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            nodes[n1].adjacent.add(n2);
            nodes[n2].adjacent.add(n1);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(!nodes[i].visited){
                dfs(i);
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int n) {
        if(!nodes[n].visited){
            nodes[n].visited = true;

            for (Integer i : nodes[n].adjacent) {
                if(!nodes[i].visited)
                    dfs(i);
            }
        }
    }
}
