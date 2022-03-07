package CLASS3;

import java.util.*;

public class boj5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] res = new String[T];

        for(int i=0; i<T; i++){
            String p = sc.next();
            int n = sc.nextInt();
            String str = sc.next();

            //[1 ,2, 3, 4]
            str = str.substring(1, str.length()-1);
            String[] arr = str.split(",");

            if(n==0) {
                arr = new String[0];
            }

            String result = AC(p, n, arr);
            res[i] = result;
        }

        for (String r : res) {
            System.out.println(r);
        }
    }

    private static String AC(String p, int n, String[] arr) {
        Deque<String> deq = new LinkedList<>(Arrays.asList(arr));

        int flag = 0;
        boolean error = false;

        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='R'){
                flag ++;
            }else if(p.charAt(i)=='D'){
                if(!deq.isEmpty()){
                    String num;
                    if(flag%2==0) num = deq.removeFirst();
                    else num = deq.removeLast();
                    System.out.println("num= "+num);
                }else{
                    error = true;
                }
            }
        }

        if(error) return "error";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(flag % 2 == 0){
            while (!deq.isEmpty()){
                String str = deq.pollFirst();
                for(int j=0; j<str.length();j++){
                    if(Character.isDigit(str.charAt(j)))
                        sb.append(str.charAt(j));
                }
                sb.append(",");
            }
        }else{
            while (!deq.isEmpty()){
                String str = deq.pollLast();
                for(int j=0; j<str.length();j++){
                    if(Character.isDigit(str.charAt(j)))
                        sb.append(str.charAt(j));
                }
                sb.append(",");
            }
        }
        if (sb.length()!=1) sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        return sb.toString();
    }

}
