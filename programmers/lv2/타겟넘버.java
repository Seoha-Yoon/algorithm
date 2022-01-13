class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer += dfs(numbers[0], 1, target, numbers);
        answer += dfs(-numbers[0], 1, target, numbers);
        
        return answer;
    }
    
    // dfs를 이용해서 찾는다.
    public int dfs(int current, int index, int target, int[] numbers){
        
        if(index>=numbers.length){
            if(current == target) return 1;
            else return 0;
        }
        int cur1 = current + numbers[index];
        int cur2 = current - numbers[index];
        
        int ans = 0;
        ans+= dfs(cur1, index+1, target, numbers);
        ans+= dfs(cur2, index+1, target, numbers);
        
        return ans;
    }
}