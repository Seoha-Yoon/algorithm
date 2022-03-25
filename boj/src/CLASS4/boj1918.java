package CLASS4;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class boj1918 {

    static HashMap<Character, Integer> priority = new HashMap<>(){{
     put('+', 1); put('-', 1); put('*', 0); put('/', 0); put('(',2); put(')', 2);
    }};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(Character.isAlphabetic(c)) sb.append(c);
            else if(c =='(') stk.push(c);
            else if(c==')'){
                while (!stk.isEmpty()){
                    if(stk.peek() == '('){
                        stk.pop();
                        break;
                    }
                    char tmp = stk.pop();
                    sb.append(tmp);
                }
            } else{
                if(stk.isEmpty()) stk.add(c);
                else{
                    char top = stk.peek();
                    if(priority.get(c) >= priority.get(top)){
                        while (!stk.isEmpty()){
                            if(priority.get(c) < priority.get(stk.peek())) break;
                            char tmp = stk.pop();
                            if(tmp == '(' || tmp ==')'){
                                continue;
                            }else sb.append(tmp);
                        }
                        stk.push(c);
                    }else{
                        stk.push(c);
                    }
                }
            }
        }
        while (!stk.isEmpty()){
            if(stk.peek() == '(' || stk.peek() ==')'){
                stk.pop();
            }else sb.append(stk.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
