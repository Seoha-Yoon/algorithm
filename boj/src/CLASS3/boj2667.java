package CLASS3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj2667 {
    static int N;
    static int map[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] building;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        building = new int[N*N+1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    cnt++;
                    dfs(i,j, cnt);
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i=1; i<=cnt; i++) {
            if(building[i] == 0) break;
            res.add(building[i]);
        }


        Collections.sort(res);

        System.out.println(cnt);
        for (Integer r : res) {
            System.out.println(r);
        }

    }

    private static void dfs(int x, int y, int num) {
        if(map[x][y]!=0){
            map[x][y] = 0;
            building[num]++;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <0 || ny<0 || nx>=N || ny >=N) continue;

                if(map[nx][ny]==1) dfs(nx, ny, num);
            }
        }
    }
}
