package DAY3;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이 완료 ( 왜 이렇게 풀었는지 설명해보기! )
public class Prob10 {
    static int result=0;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/DAY3/input10.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String number = sc.next();
            int count = sc.nextInt();

            // string number을 int 배열로 바꿈 (swap 쉽게 하려고)
            int[] numbers = new int[number.length()];
            for(int i=0; i<numbers.length; i++){
                numbers[i] = number.charAt(i)-'0';
            }

            result =0;

            // 최대 교환 횟수는 총 숫자 갯수를 넘지 않도록 한다.
            count = count<numbers.length?count:numbers.length;
            swapNum(0, count, numbers);

            System.out.println("#"+test_case+" "+ result);
        }
    }

    // 배열을 숫자로 바꿈
    static int makeNum(int[] numbers){
        int res = 0;
        for (int i=0; i<numbers.length; i++){
            res += numbers[numbers.length-i-1]*Math.pow(10,i);
        }
        return res;
    }


    // dfs 이용해서 구현 (완전탐색)
    static void swapNum(int pos, int count, int[] numbers){
        if(count==0){
            result= Math.max(result, makeNum(numbers));
            return;
        }

        for (int i=pos; i<numbers.length; i++) {
            for (int j = i+1; j<numbers.length; j++) {
                numbers[i] ^= numbers[j];
                numbers[j] ^= numbers[i];
                numbers[i] ^= numbers[j];

                swapNum(i, count - 1, numbers);

                numbers[i] ^= numbers[j];
                numbers[j] ^= numbers[i];
                numbers[i] ^= numbers[j];
            }
        }
    }
}
