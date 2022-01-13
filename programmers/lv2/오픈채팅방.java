import java.util.HashMap;

class Solution {
    
    public String[] solution(String[] record) {

        // User 저장할 HashMap<uid, name>
        HashMap<String, String> map = new HashMap<>();
        int cnt=0;
        
        // 먼저 User 저장
        for(String r: record){
            String[] input = r.split(" ");
            String status = input[0];
            String uid = input[1];
            
            if(status.equals("Enter") || status.equals("Change")){
                String name = input[2];
                
                map.put(uid, name);
                
                if(status.equals("Enter")) cnt++;
                
            }else if(status.equals("Leave")) cnt++;    
        }
        
        String[] answer = new String[cnt];
        
        // 출력
        for(int i=0, j=0; i<record.length; i++){
            String[] input = record[i].split(" ");
            String status = input[0];
            String uid = input[1];
            
            StringBuilder sb = new StringBuilder();
            
            if(!status.equals("Change")){
                // user
                sb.append(map.get(uid));
            
                if(status.equals("Enter")) sb.append("님이 들어왔습니다.");
                else if(status.equals("Leave")) sb.append("님이 나갔습니다.");
            
                answer[j] = sb.toString();
                j++;
            }
        }
        
        return answer;
    }
}