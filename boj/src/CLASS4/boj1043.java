package CLASS4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1043 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[N+1]; // 탐색 유무 체크

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(st.nextToken());
            q.add(n);
            checked[n] = true;
        }

        HashSet<Integer>[] parties = new HashSet[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int participants = Integer.parseInt(st.nextToken());

            for (int j = 0; j < participants; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = M;
        boolean[] visited = new boolean[M];
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < M; i++) {
                if(visited[i]) continue;
                if(parties[i].contains(cur)){
                    visited[i] = true;
                    answer--;
                    for (int n : parties[i]) {
                        if(!checked[n]){
                            q.add(n);
                            checked[n] = true;
                        }
                    }
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
