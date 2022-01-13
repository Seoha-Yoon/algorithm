import java.util.ArrayList;

class Solution{
    static char[] operation = {'+','-','*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        String num = "";
        
        // 연산자와 피연산자 분리해서 arraylist에 저장
        for(int i=0; i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i)=='-'||expression.charAt(i)=='*'){
                nums.add(Long.parseLong(num));
                num ="";
                ops.add(expression.charAt(i));
            }else{
                num += expression.charAt(i);
            }
        }
        nums.add(Long.parseLong(num));
        
        dfs(0, new char[3]);
        return answer;
    }
    
     public static void dfs(int count, char[] p){
         // 매 순열 우선순위에 따라 계산
        if(count == 3){
            ArrayList<Long> copyNums = new ArrayList<>(nums);
            ArrayList<Character> copyOps = new ArrayList<>(ops);
            
            for(int i=0; i<p.length;i++){
                for(int j=0; j<copyOps.size();j++){
                    if(p[i] == copyOps.get(j)){
                        Long cal = calculate(copyNums.remove(j),copyNums.remove(j),p[i]);
                        copyNums.add(j,cal);
                        copyOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyNums.get(0)));
            return;
        }
        
        // 연산자 우선순위 순열
        for(int i=0; i<3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = operation[i];
                dfs(count+1, p);
                check[i] = false;
            }
        }
    }
    
     public static Long calculate(Long num1, Long num2, char op){
         long result = 0;
         switch(op){
             case '+':
                 result =  num1 + num2;
                 break;
             case '-':
                 result =  num1 - num2;
                 break;
             case '*':
                 result =  num1 * num2;
                 break;
         }
         return result;
     }
}