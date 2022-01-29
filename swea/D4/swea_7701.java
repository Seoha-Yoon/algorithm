package DAY5;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Prob14 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/DAY5/input14.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            HashSet<String> set = new HashSet<>();
            int N = sc.nextInt();
            String[] name = new String[N];

            for(int i=0; i<N; i++){
                name[i] = sc.next();
            }

            Arrays.sort(name, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() == o2.length())
                        return o1.compareTo(o2);
                    return o1.length()-o2.length();
                }
            });

            System.out.println("#"+test_case);
            for(String n: name){
                if(!set.isEmpty()){
                    if(!set.contains(n)){
                        System.out.println(n);
                        set.add(n);
                    }
                }else{
                    System.out.println(n);
                    set.add(n);
                }

            }
        }
    }
}
