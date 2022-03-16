package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// kmp
public class boj5525 {

    static int[] pi;
    static int res, N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }
        String nStr = sb.toString();

        // nStr의 pi 배열 만들기
        pi = new int[2*N+1];
        makePi(nStr);

        res = 0;
        countStr(str, nStr);

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void countStr(String str1, String str2) {
        int j=0;

        // str1
        for (int i = 0; i < M; i++) {
            // str2
            while (j>0 && str1.charAt(i) != str2.charAt(j))
                j = pi[j-1];
            if(str1.charAt(i) == str2.charAt(j)){
                if(j==2*N){
                    j = pi[j];
                    res++;
                } else j++;
            }
        }
    }

    private static void makePi(String str) {
        int j=0;
        for (int i = 1; i < 2*N+1; i++) {
            while (j>0 && str.charAt(i) != str.charAt(j))
                j = pi[j-1];
            if(str.charAt(i) == str.charAt(j))
                pi[i] = ++j;
        }
    }
}
