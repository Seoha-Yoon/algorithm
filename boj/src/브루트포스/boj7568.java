package 브루트포스;

import java.util.Scanner;

public class boj7568 {
    static int N;
    public static class People {
        int x,y, rank;

        public People(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static People[] people;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        people = new People[N];

        for(int i=0; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            people[i] = new People(x, y);
        }

        for(int i=0; i<N; i++){
            People base = people[i];
            int cnt = 1;
            for(int j=0; j<N; j++){
                if(i!=j){
                    People other = people[j];
                    if(other.x>base.x && other.y>base.y) cnt++;
                }
            }
            System.out.print(cnt+" ");
        }

    }
}
