class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 체육복 배열
        int[] student = new int[n];
        
        // 잃어버린 사람
        for(int i: lost) student[i-1] -= 1;
        // 여분으로 가져온 사람
        for(int i: reserve) student[i-1] += 1;
        
        for(int i=0; i<n; i++){
            if(student[i]==-1){
                if(i!=0 && student[i-1]==1){
                    answer++;
                    student[i-1] -= 1;
                    continue;
                }
                
                if(i!=n-1 && student[i+1]==1){
                    answer++;
                    student[i+1] -= 1;
                    continue;
                }
                
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
    
}