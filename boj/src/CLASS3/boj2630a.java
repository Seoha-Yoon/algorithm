package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 색종이 재풀이
public class boj2630a {
    static int[][] paper;
    static int[] cnt = new int[2];
    public static void main(String[] args) throws Exception{
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

        cropPaper(0, 0, N);

        for (int i : cnt) {
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void cropPaper(int x, int y, int size) {
        if(checkPaper(x, y, size)){
            cnt[paper[x][y]]++;
            return;
        }

        int newSize = size/2;

        cropPaper(x, y, newSize);
        cropPaper(x, y+newSize, newSize);
        cropPaper(x+newSize, y, newSize);
        cropPaper(x+newSize, y+newSize, newSize);

    }

    private static boolean checkPaper(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(paper[i][j] != paper[x][y]) return false;
            }
        }
        return true;
    }
}
