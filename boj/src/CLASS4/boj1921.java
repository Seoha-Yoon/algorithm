package CLASS4;

import java.io.*;

public class boj1921 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int l1 = str1.length();
        int l2 = str2.length();
        int[][] lcs = new int[l1+1][l2+1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        bw.write(Integer.toString(lcs[l1][l2]));


        bw.flush();
        bw.close();
        br.close();
    }
}
