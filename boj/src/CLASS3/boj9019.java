package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9019 {

    static char[] orders = {'D', 'S', 'L', 'R'};

    static class Number{
        int number;
        int[] adjacent;

        public Number(int number) {
            this.number = number;
            adjacent = new int[4];

            for (int i = 0; i < 4; i++) {
                adjacent[i] = cal(number, orders[i]);
            }
        }
    }

    static Number[] numbers = new Number[10001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[][] inputs = new int[T][2];


        for (int i = 0; i <= 10000; i++) {
            numbers[i] = new Number(i);
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            inputs[i][0] = A;
            inputs[i][1] = B;
        }

        for (int i = 0; i < T; i++) {
            bw.append(findOrder(inputs[i][0], inputs[i][1]) +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String findOrder(int a, int b){
        boolean[] visited = new boolean[10001];
        String[] result = new String[10001];
        Arrays.fill(result, "");
        Queue<Number> q = new LinkedList<>();
        q.add(numbers[a]);
        visited[a] = true;

        while (!q.isEmpty()){
            Number cur = q.poll();
            if (cur.number == b) return result[b];

            for (int i = 0; i < 4; i++) {
                int next = cur.adjacent[i];
                if (!visited[next]){
                    visited[next] = true;
                    q.add(numbers[next]);
                    result[next] = result[cur.number] + orders[i];
                }
            }
        }
        return result[0];
    }

    private static int cal(int n, char c) {
        int num=0;
        switch (c){
            case 'D':
                num = (n*2)%10000;
                break;
            case 'S':
                num = (n+9999)%10000;
                break;
            case 'L':
                num = (n*10)%10000 + (n/1000);
                //num = turnLeft(n);
                break;
            case 'R':
                num = n/10 + (n%10) * 1000;
                break;
        }
        return num;
    }
}
