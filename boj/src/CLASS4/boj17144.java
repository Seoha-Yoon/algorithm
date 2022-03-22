package CLASS4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj17144 {

    static int R, C, T;
    static int[][] room;
    static int[] ac;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // read input
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        ac  = new int[2];
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int m = Integer.parseInt(st.nextToken());
                if(m == -1){
                    ac[cnt] = i;
                    cnt++;
                }
                room[i][j] = m;

            }
        }

        while(T>0){
            //  미세먼지 확산
            diffusion();
            // 공기청정기 작동
            turnOnAC();
            T--;
        }

        // 남은 미세먼지 계산
        System.out.println(checkRC());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int checkRC() {
        int tot = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(room[i][j] == -1) continue;
                tot += room[i][j];
            }
        }
        return tot;
    }

    private static void turnOnAC() {
        int ac1 = ac[0];
        int ac2 = ac[1];

        // 위
        int tmp = room[ac1][1];

        room[ac1][1] = 0;
        for (int i = 2; i < C-1; i++) {
            int tt = room[ac1][i];
            room[ac1][i] = tmp;
            tmp = tt;
        }
        for (int i = ac1; i >=0 ; i--) {
            int tt = room[i][C-1];
            room[i][C-1] = tmp;
            tmp = tt;
        }
        for (int i = C-2; i > 0; i--) {
            int tt = room[0][i];
            room[0][i] = tmp;
            tmp = tt;
        }
        for (int i = 0; i < ac1; i++){
            int tt = room[i][0];
            room[i][0] = tmp;
            tmp =tt;
        }

        // 아래
        tmp = room[ac2][1];

        room[ac2][1] = 0;
        for (int i = 2; i < C-1; i++) {
            int tt =room[ac2][i];
            room[ac2][i] = tmp;
            tmp = tt;
        }
        for (int i = ac2; i <R-1 ; i++) {
            int tt = room[i][C-1];
            room[i][C-1] = tmp;
            tmp = tt;
        }
        for (int i = C-1; i >= 0; i--) {
            int tt = room[R-1][i];
            room[R-1][i] = tmp;
            tmp = tt;
        }
        for (int i = R-2; i > ac2; i--){
            int tt = room[i][0];
            room[i][0] = tmp;
            tmp =tt;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void diffusion() {
        int[][] diff = new int[R][C];

        for (int i = 0; i <R ; i++) {
            for (int j = 0; j < C; j++) {
                if(room[i][j] == -1) diff[i][j] = -1;
                if (room[i][j] != 0 && room[i][j] != -1) {
                    int amount = room[i][j];
                    int diff_amount = amount / 5;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || room[nx][ny]==-1) continue;
                        diff[nx][ny] += diff_amount;
                        cnt++;
                    }
                    diff[i][j] += (amount - diff_amount * cnt);
                }
            }
        }
        room = diff;
    }
}
