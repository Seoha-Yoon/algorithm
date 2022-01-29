package DAY5;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이중.. 분할 정복으로 가능한가?
// Parametric Search 사용?
// 투포인터 풀이 (타인 풀이 사용) -> 꼭 혼자 구현 연습해보기 / 표 그려보기
public class Prob15 {

    static int MAX_DAY = 1000000;
    static boolean[] checked;
    static int days[];

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY5/input15.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt(); // 실제로 공부한 날의 개수
            int p = sc.nextInt(); // 추가할 수 있는 날의 수

            days = new int[MAX_DAY+1];
            checked = new boolean[MAX_DAY+1];

            for(int i=1; i<=n; i++) days[i] = sc.nextInt();
            for(int d: days) checked[d] = true;

            // 해킹 가능한 날의 개수 이용해서 연속 날짜 찾음
            System.out.println("#"+test_case+" "+checkDays(p));

        }
    }

    private static int checkDays(int p) {
        int start = 1, end = 1;
        int num = 0;
        int max = p+1;

        while (end<days.length){
            if(checked[end]){
                num++;
                end++;
                max = Math.max(num, max);
            }else{
                if(p==0){
                    max = Math.max(num, max);
                    if(!checked[start]) p++;
                    start++;
                    num--;
                }else{
                    p--;
                    num++;
                    end++;
                }
            }
        }

        return max;
    }
}
