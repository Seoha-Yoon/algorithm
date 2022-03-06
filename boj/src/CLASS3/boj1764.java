package CLASS3;

import java.util.*;

public class boj1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        int cnt=0;
        ArrayList<String> res = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            String name = sc.next();
            if(set.contains(name)) {
                cnt++;
                res.add(name);
            }
        }

        System.out.println(cnt);
        Collections.sort(res);
        for (String r : res) {
            System.out.println(r);
        }
    }
}
