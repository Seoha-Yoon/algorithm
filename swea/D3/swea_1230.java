package DAY2;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Prob4 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY2/input4.txt"));

        Scanner sc = new Scanner(System.in);
        int T=10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int len = sc.nextInt();
            // System.out.println("len: "+len);

            // 암호문 각 숫자의 연결에 linkedList 이용
            LinkedList<Integer> list = new LinkedList<>();

            for(int i=0; i<len; i++){
                list.add(sc.nextInt());
            }

            int numOfState = sc.nextInt();
            // System.out.println("numOfStatements: "+numOfState);

            for(int i=0; i<numOfState; i++){
                String s = sc.next();
                int x, y;

                switch (s){
                    case "I":
                        x = sc.nextInt();
                        y = sc.nextInt();
                        for(int j=0; j<y; j++){
                            list.add(x+j,sc.nextInt());
                        }
                        break;
                    case "D":
                        x = sc.nextInt();
                        y = sc.nextInt();
                        for(int j=1; j<=y; j++){
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = sc.nextInt();
                        for(int j=1; j<=y; j++){
                            list.addLast(sc.nextInt());
                        }
                        break;
                    default:
                        break;
                }
            }

            System.out.print("#"+test_case+" ");

            Object[] arr = list.toArray();
            for(int i=0; i<10; i++){
                System.out.print(arr[i]+" ");
            }

            System.out.println();
        }
    }
}
