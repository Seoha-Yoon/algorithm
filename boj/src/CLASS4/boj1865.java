package CLASS4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 음수가 포함된 최단거리 -> 벨만-포드
public class boj1865 {
    
    static int[][] graph;
    static int[] dist;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        String[] result = new String[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            graph = new int[N+1][N+1];

            for (int j = 1; j <= N; j++) {
                Arrays.fill(graph[j], Integer.MAX_VALUE);
            }

            // 도로
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s][e] = Math.min(graph[s][e], t);
                graph[e][s] = Math.min(graph[e][s], t);
            }

            // 웜홀
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s][e] = -t;
            }

            // 벨만 포드 사용해서 음수 사이클 발견하면 YES, 아니면 NO
            dist = new int[N+1];
            result[i] = "NO";
            if(find(1)){
                result[i] = "YES";
            }
        }

        for (String s : result) {
            bw.write(s+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 모든 노드에서 동시에 출발한다 가정
    private static boolean find(int s) {
       // n-1 번 반복
        for (int i = 0; i < N-1; i++) {
            for (int j = 1; j <=N; j++) {
                for (int k = 1; k <=N ; k++) {
                    if(graph[j][k] == Integer.MAX_VALUE) continue;
                    if(dist[k] > dist[j]+graph[j][k]){
                        dist[k] = dist[j]+ graph[j][k];
                    }
                }
            }
        }

        // 한 번 더 갱신
        for (int j = 0; j <=N; j++) {
            for (int k = 0; k <=N ; k++) {
                if(graph[j][k] == Integer.MAX_VALUE) continue;
                if(dist[k] > dist[j]+graph[j][k]){
                    return true;
                }
            }
        }
        return false;
    }
}
