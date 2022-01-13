package String;
import java.util.Scanner;

// 12. 암호
/*
4
#****###**#####**#####**##**

COOL
 */
public class String12 {
    public String solution(int n, String str){
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (num<str.length()){
            String binary=str.substring(num,num+7);
            binary = binary.replace("#","1");
            binary = binary.replace("*","0");

            // Binary to Decimal
            int decimal = Integer.parseInt(binary, 2);

            // Decimal to ASCII
            sb.append((char)decimal);
            num+=7;
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String12 T = new String12();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(); // 문자열 읽기
        String str = kb.next();

        System.out.print(T.solution(n, str));
    }
}