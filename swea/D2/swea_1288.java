package DAY1;

import java.io.FileInputStream;
import java.util.Scanner;

class Prob1
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY1/input1.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();
            int res = 1;
            int base = 0; // 기준 숫자

            while(true){
                String numString = Integer.toString(N*res);
                for(char c: numString.toCharArray()){
                    int cNum = (int)Math.pow(2, c-'0');
                    base = base|cNum;
                }

                if(base == Math.pow(2,10)-1) break;
                res++;
            }
            res *= N;

            System.out.println("#"+test_case+" "+res);
        }
    }
}