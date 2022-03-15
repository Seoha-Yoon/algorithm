package CLASS3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] img;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                img[i][j] = str.charAt(j)-'0';
            }
        }
        compressImg(0, 0, N);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void compressImg(int x, int y, int size) {
        int flag = checkImg(x, y, size);
        if(flag!=-1){
            sb.append(flag);
            return;
        }

        // 압축이 불가능할 경우 사이즈를 n/2로 줄인다.
        int len = size/2;

        sb.append('('); // 각 레벨에서 여는 괄호

        compressImg(x, y, len); // 1 사분면
        compressImg(x, y+len, len); // 2 사분면
        compressImg(x+len, y, len); // 3 사분면
        compressImg(x+len, y+len, len); // 4 사분면

        sb.append(')');
    }

    private static int checkImg(int x, int y, int size) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(img[i][j]!=img[x][y]) return -1;
            }
        }
        return img[x][y];
    }
}
