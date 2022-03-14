package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2630 {
    static int[][] paper;
    static int[] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = new int[2];
        cropPaper(paper);

        for (int i : cnt) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void cropPaper(int[][] paper) {
        int flag = check(paper);
        if(flag!=-1){
            cnt[flag]++;
            return;
        }

        int len = paper.length;
        // 1번
        int[][] tmp1 = new int[len/2][len/2];
        int[][] tmp2 = new int[len/2][len/2];
        int[][] tmp3 = new int[len/2][len/2];
        int[][] tmp4 = new int[len/2][len/2];

        for (int i = 0; i <len/2; i++) {
            for (int j = 0; j < len/2; j++) {
                tmp1[i][j] = paper[i][j];
            }

            for (int j = len/2; j < len; j++) {
                tmp3[i][j-len/2] = paper[i][j];
            }
        }

        for (int i = len/2; i <len; i++) {
            for (int j = 0; j < len/2; j++) {
                tmp2[i-len/2][j] = paper[i][j];
            }

            for (int j = len/2; j < len; j++) {
                tmp4[i-len/2][j-len/2] = paper[i][j];
            }
        }

        cropPaper(tmp1);
        cropPaper(tmp2);
        cropPaper(tmp3);
        cropPaper(tmp4);
    }

    static public int check(int[][] img){
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img.length; j++) {
                if(img[i][j]!=img[0][0]) return -1;
             }
        }
        return img[0][0];
    }
}
