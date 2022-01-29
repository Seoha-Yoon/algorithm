package DAY8;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;


public class Prob26 {
    static int N;
    static int[][] tree;
    static HashMap<Integer,String> map;


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY8/input26.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            sc.nextLine(); // nextInt 다음 nextLine = '\n'
            tree = new int[N+1][2];
            map = new HashMap<>();

            // make tree
            for(int i=1; i<=N; i++){
                String str = sc.nextLine();
                String[] starr = str.split(" ");
                int len = starr.length;
                int num=0, left=-1, right=-1;
                String data="";

                switch (len){
                    case 2:
                        num = Integer.parseInt(starr[0]);
                        data = starr[1];
                        break;
                    case 3:
                        num = Integer.parseInt(starr[0]);
                        data = starr[1];
                        left = Integer.parseInt(starr[2]);
                        break;
                    case 4:
                        num = Integer.parseInt(starr[0]);
                        data = starr[1];
                        left = Integer.parseInt(starr[2]);
                        right = Integer.parseInt(starr[3]);
                        break;
                }

                tree[i][0] = left;
                tree[i][1] = right;
                map.put(num, data);
            }

            System.out.print("#"+test_case+" ");
            inOrder(1);
            System.out.println();
        }
    }

    private static void inOrder(int node){
        if(tree[node][0] == -1 && tree[node][1]==-1)
            System.out.print(map.get(node));
        else{
            if(tree[node][0]!=-1) inOrder(tree[node][0]);
            System.out.print(map.get(node));
            if(tree[node][1]!=-1) inOrder(tree[node][1]);
        }
    }
}
