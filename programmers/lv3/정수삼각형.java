class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 뒤에서 두번째 줄부터 값 갱신 시작
        for(int i = triangle.length-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int n1 = triangle[i][j] + triangle[i+1][j];
                int n2 = triangle[i][j] + triangle[i+1][j+1];
                
                // 둘중에 더 큰 값으로 값 갱신
                triangle[i][j] = Math.max(n1, n2);
            }
        }
        answer = triangle[0][0];
        
        return answer;
    }
}