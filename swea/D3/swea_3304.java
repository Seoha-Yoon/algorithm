package DAY4;

import java.io.FileInputStream;
import java.util.Scanner;

// LCS (Longest Common Subsequence)
public class Prob11 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY4/input11.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s1 = sc.next(); // acakp
            String s2 = sc.next();// capcak

            int[][] ans = new int[s1.length()+1][s2.length()+1];

            for (int i=1; i<=s1.length(); i++){
                for(int j=1; j<=s2.length(); j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        ans[i][j] = ans[i-1][j-1]+1;
                    else
                        ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
                }
            }

            int res = ans[s1.length()][s2.length()];

            System.out.println("#"+test_case+" "+res);
        }
    }
}
