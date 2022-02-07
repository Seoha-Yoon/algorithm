package DAY13;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.HashSet;

// 2948. 문자열 교집합
public class Prob37 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY13/input37.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int res = 0;

            HashSet<String> set = new HashSet<>();

            for(int i=0; i<N; i++){
                String str = sc.next();
                set.add(str);
            }

            for (int i=0; i<M; i++){
                String str = sc.next();
                if(set.contains(str)) res++;
            }

            System.out.println("#"+test_case+" "+res);
        }
    }
}
