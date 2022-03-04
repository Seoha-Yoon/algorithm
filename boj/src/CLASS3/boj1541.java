package CLASS3;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class boj1541 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Integer> operands = new ArrayList<>();

        // - 기준으로 식을 나눈다.
        String[] express = str.split("-");

        int res = 0;
        for(int i=0; i<express.length; i++){

            String s = express[i];
            int sum = 0;

            String[] ss = s.split("\\+");
            for (int j=0; j<ss.length; j++){
                sum += Integer.parseInt(ss[j]);
            }

            if(i==0) res+=sum;
            else res-=sum;
        }
        System.out.println(res);

    }


}
