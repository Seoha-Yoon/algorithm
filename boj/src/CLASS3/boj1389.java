package CLASS3;

import java.util.Arrays;
import java.util.Scanner;

// 일반 배열 사용 다익스트라
public class boj1389 {
    static boolean[][] map; // 노드들 간의 가중치 저장
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        int res = Integer.MAX_VALUE;
        int result = 0;

        map = new boolean[N+1][N+1];

        for(int i=0; i<M; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            map[n][m] = true;
            map[m][n] = true;
        }

        for(int i=1; i<=N; i++){
            int n = dijkstra(i);
            if(res>n){
                res = n;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static int dijkstra(int n) {
        int[] distance = new int[N+1];
        boolean[] check = new boolean[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[n] = 0;
        check[n] = true;

        for(int i=1; i<=N; i++){
            if(!check[i] && map[n][i])
                distance[i] = 1;
        }

        for(int i=0; i<N-1; i++){

            int min = Integer.MAX_VALUE;
            int min_index = -1;

            for(int j=1; j<=N; j++){
                if(!check[j] && distance[j]!=Integer.MAX_VALUE){
                    if(distance[j]<min){
                        min = distance[j];
                        min_index = j;
                    }
                }
            }
            check[min_index] = true;

            for(int j=1; j<=N; j++){
                if(!check[j] && map[min_index][j]){
                    if(distance[j]>distance[min_index]+1){
                        distance[j] = distance[min_index]+1;
                    }
                }
            }
        }

        int sum = 0;
        for(int i=1; i<=N; i++){
            sum += distance[i];
        }
        return sum;
    }
}
