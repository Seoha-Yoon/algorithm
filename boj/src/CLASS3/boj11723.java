package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *  Scanner 시간초과남. bufferedReader로 인풋 읽기!!!!
 */
public class boj11723 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            String o = st.nextToken();
            int num;
            switch (o){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) result.add(1);
                    else result.add(0);
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        for (int s : result) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
