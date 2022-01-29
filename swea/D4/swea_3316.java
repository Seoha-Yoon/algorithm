package DAY1;
import java.io.FileInputStream;
import java.util.Scanner;

class Prob2
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY1/input2.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int base = (int)Math.pow(2,N)-1;
            int num = M;

            String res = "OFF";

            if((base & num) == base) res = "ON";

            System.out.println("#"+test_case+" "+res);
        }
    }
}