package DAY5;

import java.io.FileInputStream;
import java.util.Scanner;

public class Prob16 {

    static int L, N;
    static Peak[] times;
    static int[] sum;

    static class Peak{
        int s, e;

        public Peak(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY5/input_sample16.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            L = sc.nextInt(); // L분
            N = sc.nextInt(); // N개의 피크타임
            times = new Peak[N+1];
            sum = new int[N+1];
            times[0] = new Peak(0,0);

            for (int i=1; i<=N; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                times[i] = new Peak(s, e); // 피크타임 저장
                sum[i] = times[i].e - times[i].s + sum[i-1];// 시간의 누적합 계산
            }

            System.out.println("#"+test_case+" "+solve());
        }
    }

    static int binarySearch(int l, int r, int pos){
        if(l>r) return r;

        int m = l + (r-l)/2;

        if(times[m].s <= pos && pos<=times[m].e)
            return m;
        else if(pos < times[m].s)
            return binarySearch(l, m-1, pos);
        else
            return binarySearch(m+1, r, pos);
    }

    static int solve(){
        int max = 0, temp;

        for(int i=1; i<=N; i++){
            // i번째 시간에서 시작할 때, L분 뒤 끝나는 시간 찾기
            int r = binarySearch(1, N, times[i].s+L);
            temp = sum[r]-sum[i-1];
            if(times[r].e > times[i].s +L)
                temp = temp - (times[r].e - times[i].s - L);
            if(temp>max)
                max = temp;
        }
        return max;
    }

}
