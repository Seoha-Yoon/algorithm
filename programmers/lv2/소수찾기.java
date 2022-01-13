import java.util.*;

class Solution {
    int answer = 0;
    // 이미 만들어진 소수인지 아닌지 판별해주는 친구
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
    
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i=1; i<=numbers.length(); i++){
            StringBuilder res = new StringBuilder(""); 
            perm(numbers, visited, i, res, 0);
        }
        
        return answer;
    }
    
    public boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;