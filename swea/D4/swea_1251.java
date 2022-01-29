package DAY7;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 간선을 찾고 그 간선 비용의 최솟값을 구하는 문제
// MST(Minimum Spanning Tree)로 해결 - 크루스칼
public class Prob22 {

    static class Node{
        int num;
        int x, y;
        public Node(int num, int x, int y){
            this.num = num; this.x = x; this.y = y;
        }
    }

    static class Edge {
        Node[] n = new Node[2];
        long distance; // 비용

        public Edge(Node node1, Node node2, long distance) {
            n[0] = node1;
            n[1] = node2;
            this.distance = distance;
        }
    }

    static int N;
    static double E;
    static int[] parent; // 그래프 cycle 확인용 테이블
    static Node[] nodes;
    static ArrayList<Edge> edges;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY7/input22.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            parent = new int[N];
            nodes = new Node[N];
            edges = new ArrayList<>();
            int[] x = new int[N];
            int[] y = new int[N];

            for (int i=0; i<N; i++)
                x[i] = sc.nextInt();

            for (int i=0; i<N; i++)
                y[i] = sc.nextInt();


            // parent 배열 초기화
            for(int i=0; i<N; i++){
                parent[i] = i;
                nodes[i] = new Node(i, x[i], y[i]);
            }

            E = sc.nextDouble();

            // Edge 정보 저장
            for (int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    edges.add(new Edge(nodes[i], nodes[j], calculateD(nodes[i], nodes[j])));
                }
            }

            edges.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge e1, Edge e2) {
                    if(e1.distance == e2.distance) return 0;
                    return e1.distance < e2.distance? -1: 1;
                }
            });

            int cnt = 0;
            long sum = 0;
            for(int i=0; i<edges.size(); i++){
                if(find(edges.get(i).n[0].num, edges.get(i).n[1].num)){
                    sum+=edges.get(i).distance;
                    unionParent(edges.get(i).n[0].num, edges.get(i).n[1].num);
                    cnt++;
                }
                if (cnt==N-1) break;
            }

            double res = E*sum;
            System.out.println("#"+test_case+" "+Math.round(res));
        }
    }

    private static int getParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean find(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return false; // 부모가 같으면
        else return true;
    }

    private static long calculateD(Node i1, Node i2){
        long distance = (long) (i1.x-i2.x) *(i1.x-i2.x) + (long) (i1.y-i2.y) *(i1.y-i2.y);
        return distance;
    }
}
