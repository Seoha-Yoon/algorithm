package CLASS3;

import java.util.Scanner;

public class boj1780 {

    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] paper = new int[N][N];
        count = new int[3]; // -1, 0, 1 저장할 배열

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        cropPaper(paper, N);

        for (int i : count) {
            System.out.println(i);
        }
    }

    private static void cropPaper(int[][] paper, int N) {
        if(checkPaper(paper, N)){
            count[paper[0][0]+1]++;
            return;
        }

        for (int i = 0; i < N; i += N/3 ) {
            for (int j = 0; j < N; j+= N/3 ) {
                if(N/3 == 1){
                    count[paper[i][j]+1]++;
                    continue;
                }
                int[][] temp = new int[N/3][N/3];
                for (int x = i; x < i+N/3; x++) {
                    for (int y = j; y < j+N/3; y++) {
                        temp[x-i][y-j] = paper[x][y];
                    }
                }
                cropPaper(temp, N/3);
            }
        }
    }

    private static boolean checkPaper(int[][] paper, int N) {
        int flag = paper[0][0];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if(paper[i][j] != flag) return false;
            }
        }
        return true;
    }
}
