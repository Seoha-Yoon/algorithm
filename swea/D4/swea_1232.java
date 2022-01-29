package DAY8;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

// 후위순회로 해서 Stack을 이용해 계산
public class Prob28 {
    static int N;
    static int[][] tree;
    static HashMap<Integer, String> map;
    static StringBuilder sb;

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY8/input28.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            sc.nextLine();
            map = new HashMap<>();
            tree = new int[N+1][2];

            // make tree
            for(int i=1; i<=N; i++){
                String str = sc.nextLine();
                String[] starr = str.split(" ");
                String data="";
                int left=-1, right=-1;

                if(starr.length == 2){
                    data = starr[1];
                }else if(starr.length==4){
                    data = starr[1];
                    left = Integer.parseInt(starr[2]);
                    right = Integer.parseInt(starr[3]);
                }
                tree[i][0] = left;
                tree[i][1] = right;

                map.put(i, data);
            }

            sb = new StringBuilder();
            postOrder(1);
            int res = (int)calculate(sb.toString());

            System.out.println("#"+test_case+" "+res);
        }
    }
    private static void postOrder(int i){
        if(tree[i][0]!=-1) postOrder(tree[i][0]);
        if(tree[i][1]!=-1) postOrder(tree[i][1]);
        sb.append(map.get(i));
        sb.append(" ");
    }

    private static double calculate(String s){
        Stack<Double> stk = new Stack<>();

        String[] ss = s.split(" ");
        for(int i=0; i<ss.length; i++){
            if(ss[i].equals("*")||ss[i].equals("-")||ss[i].equals("/")||ss[i].equals("+")){
                double num1 = stk.pop();
                double num2 = stk.pop();
                double res = cal(num1, num2, ss[i]);
                stk.push(res);
            }else{
                double num = Double.parseDouble(ss[i]);
                stk.push(num);
            }
        }

        return stk.pop();
    }

    private static double cal(double num1, double num2, String s){
        double res = 0;
        switch (s){
            case "+":
                res = num2 + num1;
                break;
            case "*":
                res = num2 * num1;
                break;
            case "-":
                res = num2 - num1;
                break;
            case "/":
                res = num2 / num1;
                break;
        }
        return res;
    }
}
