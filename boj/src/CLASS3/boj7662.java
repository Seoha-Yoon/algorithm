package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj7662 {
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minh = new PriorityQueue<>();
            PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
            // 중복된 값들에 대한 처리
            map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                String q = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (q.equals("I")){
                    minh.add(num);
                    maxh.add(num);
                    map.put(num, map.getOrDefault(num, 0)+1);
                }else{
                    if(map.isEmpty()) continue;
                    if(num == -1){
                        delete(minh);
                    }
                    else{
                        delete(maxh);
                    }

                }
            }

            StringBuilder sb = new StringBuilder();
            if(map.isEmpty()) result.add("EMPTY");
            else{
                int res = delete(maxh);
                sb.append(res+" ");// 최대
                if(!map.isEmpty()) sb.append(delete(minh));
                else sb.append(res);
                result.add(sb.toString());
            }

        }
        for (String s : result) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int delete(Queue<Integer> pq) {
        int res = 0;

        while (true){
            res = pq.poll();

            int cnt = map.getOrDefault(res,0);

            if(cnt == 0) continue;
            else if(cnt == 1) map.remove(res);
            else{
                map.put(res, cnt-1);
            }
            break;
        }
        return res;
    }
}
