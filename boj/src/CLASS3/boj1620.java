package CLASS3;

import java.util.HashMap;
import java.util.Scanner;

public class boj1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] numToString = new String[N+1];
        HashMap<String, Integer> stringToInt = new HashMap<>();
        String[] res = new String[M];

        for(int i=1; i<=N; i++){
            String name = sc.next();
            numToString[i] = name;
            stringToInt.put(name, i);
        }

        for(int i=0; i<M; i++){
            res[i] = sc.next();
        }

        for(int i=0; i<M; i++){
            String r = res[i];
            if(Character.isDigit(r.charAt(0))){
                System.out.println(numToString[Integer.parseInt(r)]);
            }else{
                System.out.println(stringToInt.get(r));
            }
        }
    }
}
