/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoonseoha
 */
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // stack이 비어있을 때에 대한 처리
            if(stk.isEmpty()){
                if(c=='('){
                    stk.push(c);
                }else{
                    answer = false;
                    stk.push(c);
                    break;
                }
            }else{
                // stack이 비어있지 않을 때
                if(stk.peek()!=c) stk.pop();
                else stk.push(c);
            } 
        }

        if(stk.isEmpty()) answer = true;
        else answer = false;


        return answer;
    }
}