package CLASS4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 시간초과 -> 해결
public class boj1167 {

    static int maxDistance = 0, max_node;
    static class Node{
        int num;
        ArrayList<int[]> adjacent;

        public Node(int num) {
            this.num = num;
            adjacent = new ArrayList<>();
        }
    }
    static Node[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        tree = new Node[V+1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int n;
            while ((n=Integer.parseInt(st.nextToken()))!=-1){
                int[] info = new int[2];
                info[0] = n;
                info[1] = Integer.parseInt(st.nextToken());

                tree[num].adjacent.add(info);
            }
        }

        visited = new boolean[V+1];
        max_node = 0;

        // 각 노드에서 멀리있는 노드를 탐색하지 않고, 두번의 탐색으로 구할 수 있음
        // 임의의 노드 1에서 가장 먼 거리의 노드 탐색
        findMax(1, 0);
        visited = new boolean[V+1];
        // 가작 먼 거리의 노드에서'의' 가장 먼 거리에 있는 노드까지의 거리 탐색
        findMax(max_node, 0);

        bw.write(Integer.toString(maxDistance));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findMax(int n, int sum) {
        if(maxDistance < sum){
            maxDistance = sum;
            max_node = n;
        }

        if(!visited[n]){
            visited[n] = true;
            for (int[] info : tree[n].adjacent) {
                if(!visited[info[0]]){
                    findMax(info[0], sum+info[1]);
                }
            }
        }
    }
}
