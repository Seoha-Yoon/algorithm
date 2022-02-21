package 브루트포스;

import java.util.Scanner;

public class boj1018 {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int min = Integer.MAX_VALUE;
        char[][] board = new char[N][M];

        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                char[][] paint = new char[N][M];
                for(int x=0; x<N; x++){
                    for(int y=0; y<M; y++)
                        paint[x][y] = board[x][y];
                }
                min = Math.min(min, repaint('B', paint, i, j));

            }
        }

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                char[][] paint = new char[N][M];
                for(int x=0; x<N; x++){
                    for(int y=0; y<M; y++)
                        paint[x][y] = board[x][y];
                }
                min = Math.min(min, repaint('W', paint, i, j));

            }
        }

        System.out.println(min);

    }

    public static int repaint(char color, char[][] paint, int x, int y){
        int cnt = 0;
        char top = color;
        char other = top == 'B'?'W':'B';

        for(int i=x; i<x+8; i++){
            if(i%2==0){
                for(int j=y; j<y+8; j+=2) {
                    if (paint[i][j] != top) {
                        paint[i][j] = top;
                        cnt++;
                    }
                }
                for(int j=y+1; j<y+8; j+=2) {
                    if (paint[i][j] != other) {
                        paint[i][j] = other;
                        cnt++;
                    }
                }
            }else{
                for(int j=y; j<y+8; j+=2) {
                    if (paint[i][j] != other) {
                        paint[i][j] = other;
                        cnt++;
                    }
                }
                for(int j=y+1; j<y+8; j+=2) {
                    if (paint[i][j] != top) {
                        paint[i][j] = top;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
