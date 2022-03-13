package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj18870 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            if(set.isEmpty() || !set.contains(n)) {
                list.add(n);
                set.add(n);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i : arr) {
            bw.write(map.get(i)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
