class Solution {
    public String[] makeMap(int n, int[] arr){
        String[] map = new String[arr.length];
        
        for(int i=0; i<arr.length; i++){
            int num = n;
            int a = arr[i];
            StringBuilder sb = new StringBuilder();
            
            while(num>0){
                sb.append(a%2);
                a /= 2;
                num--;
            }
            map[i] = sb.reverse().toString();
        }
        
        return map;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = makeMap(n, arr1);
        String[] map2 = makeMap(n, arr2);
        
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(map1[i].charAt(j)=='1' || map2[i].charAt(j)=='1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}