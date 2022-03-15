package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj11403 {

    static class Node{
        ArrayList<Integer> next;
        int num;

        public Node(int num) {
            this.num = num;
            next = new ArrayList<>();
        }
    }

    static Node nodes[];
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==1){
                    nodes[i].next.add(j);
                }
            }
        }

        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(checkWayOrNot(i+1, j+1)){
                    result[i][j] = 1;
                }else{
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkWayOrNot(int i, int j) {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stk = new Stack<>();
        if(i==j){
            for (int n : nodes[i].next) {
                stk.push(n);
            }
        }else{
            stk.push(i);
        }
        while (!stk.isEmpty()){
            int cur =stk.pop();
            if(visited[cur]) continue;
            visited[cur] = true;
            if(cur == j) return true;

            for (int n : nodes[cur].next) {
                if(!visited[n]) stk.push(n);
            }
        }
        return false;
    }
}
