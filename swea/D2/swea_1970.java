package DAY3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

class Prob8
{
    // 돈 - 배열 연결
    public static HashMap<Integer, Integer> map = new HashMap<>(){{
        put(0, 50000); put(1, 10000); put(2, 5000); put(3, 1000);
        put(4, 500); put(5, 100); put(6, 50); put(7, 10);
    }};

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY3/input8.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int money = sc.nextInt();

            // 각각 사용되는 횟수 저장하는 돈 배열
            int[] count = new int[8];

            // 결과
            System.out.println("#"+test_case+" ");
            for(int cnt: makeChange(money, count, 0)){
                System.out.print(cnt+" ");
            }
            System.out.println();
        }
    }

    public static int[] makeChange(int money, int[] count, int i){
        // 거스름돈 계산이 다 끝나면 배열 리턴
        if(money == 0 || i >= 8) return count;

        int unit = map.get(i);

        if(unit>money) return makeChange(money, count, i+1);
        else{
            int n = money/unit;
            money -= n*unit;
            count[i] += n;
            return makeChange(money, count, i+1);
        }
    }

}