package CLASS3;

import java.util.Arrays;
import java.util.Scanner;

public class boj1931 {

    static class Meeting implements Comparable<Meeting>{
        int s,e;
        int time;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
            time = this.s - this.e;
        }

        // 끝나는 시간에 대하여 오름차순 정렬
        @Override
        public int compareTo(Meeting meeting) {
            if(this.e == meeting.e)
                return this.s - meeting.s;
            return this.e - meeting.e;
        }
    }

    static Meeting[] meetings;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings);

        int end = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            if(meetings[i].s >= end){
                res++;
                end = meetings[i].e;
            }
        }

        System.out.println(res);

    }
}
