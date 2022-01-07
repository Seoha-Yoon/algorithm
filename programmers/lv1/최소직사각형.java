class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 최대값 찾아야함
        int height = 0;
        int width = 0;
        
        // 더 긴 길이 -> 가로, 짧은 길이 -> 세로
        for(int[] size: sizes){
            int h, w;
            if(size[0]>=size[1]){
                w = size[0];
                h = size[1];
            }else{
                w = size[1];
                h = size[0];
            }
            
            // 가로, 세로에 관해서 최대값 구하기
            if(w>=width) width = w;
            if(h>=height) height = h;
        }
        
        answer = width*height;
        
        return answer;
    }
}