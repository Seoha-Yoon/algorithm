package CLASS3;

import java.util.HashMap;
import java.util.Scanner;

public class boj9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] res = new int[T];

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int num = 1;
            sc.nextLine(); // nextInt 때문에!
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] cloth = sc.nextLine().split(" ");
                clothes.put(cloth[1], clothes.getOrDefault(cloth[1], 0)+1);
            }

            for (Integer value : clothes.values()) {
                num *= value+1;
            }

            res[i] = num-1;
        }

        for (int re : res) {
            System.out.println(re);
        }
    }
}
