package DAY8;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Prob27 {

    static int N;
    static int[][] tree;
    static HashMap<Integer, Integer> map;
    static int res;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY8/input27.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            tree = new int[N+1][2];
            map = new HashMap<>();

            sc.nextLine();
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

                // 숫자면 0, 사칙연산이면 1
                int type = data.charAt(0)-'0'>=0 && data.charAt(0)-'0'<=10 ?0:1;
                map.put(num, type);
            }

            res = 1;
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(1, list);
            System.out.println("#"+test_case+" "+res);
        }
    }

    private static void inOrder(int i, ArrayList<Integer> list){
        if(tree[i][0]!=-1) inOrder(tree[i][0], list);
        if(!list.isEmpty()){
            if(list.get(list.size()-1)==map.get(i)){
                res = 0;
                return;
            }
        }
        list.add(map.get(i));
        if(tree[i][1]!=-1) inOrder(tree[i][1], list);
    }
}
