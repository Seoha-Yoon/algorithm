package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16928 {

    static int arr[];
    static int distance[];
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[101];
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr[n1] = n2;
        }
        distance = new int[101];
        bfs();

        bw.write(distance[100]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        arr[1] = -1;

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur+i;
                if (next>100) continue;

                if(arr[next]!=-1){

                    // 사다리나 뱀이 있으면 끝까지 이동
                    while(true){
                        int next_n = arr[next];
                        if (next_n<=0) break;
                        next = next_n;
                    }
                    if(arr[next]==-1) continue;
                    q.add(next);
                    arr[next] = -1;
                    distance[next] = distance[cur] + 1;
                }
            }
        }
    }
}
