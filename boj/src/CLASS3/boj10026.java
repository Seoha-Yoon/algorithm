package CLASS3;

import java.util.Scanner;
import java.util.Stack;

public class boj10026 {

    static char[][] img1, img2;

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        img1 = new char[N][N];
        img2 = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                img1[i][j] = c;
                if(c == 'R' || c =='G') c = 'M';
                img2[i][j] = c;
            }
        }

        int cnt1 = 0, cnt2=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(img1[i][j] != 'V'){
                    img1 = visitArea(img1, i, j, 1);
                    cnt1++;
                }
                if(img2[i][j] != 'V'){
                    img2 = visitArea(img2, i, j, 2);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1+" "+cnt2);
    }

    private static char[][] visitArea(char[][] img, int x, int y, int n) {
        Stack<Point> stk = new Stack<>();
        stk.push(new Point(x, y));

        while (!stk.isEmpty()){
            Point cur = stk.pop();
            if(img[cur.x][cur.y] != 'V'){
                char color = img[cur.x][cur.y];
                img[cur.x][cur.y] = 'V';
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || ny <0 ||nx>=N || ny>=N) continue;

                    if(img[nx][ny] != 'V' && img[nx][ny] == color){
                        stk.push(new Point(nx, ny));
                    }
                }
            }
        }
        return img;
    }
}
