import java.util.*;

class Solution {
    
    // 출발, 도착 티켓 정보 저장
    HashMap<String, ArrayList<String>> info;
    ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        
        // 티켓 정보 저장
        info = new HashMap<>();
        
        for(int i=0; i<tickets.length; i++){
            String dep = tickets[i][0];
            String arr = tickets[i][1];
            
            ArrayList<String> list;
            
            // map이 비어있으면
            if(info.isEmpty()){
                list = new ArrayList<>();
            }else{
                // map이 비어있지 않으나, dep가 없는 경우
                if(!info.containsKey(dep)) list = new ArrayList<>();
                else list = info.get(dep);
            }
            list.add(arr);
            // 정렬 (오름차순)
            Collections.sort(list);
            info.put(dep,list);
        }
        
        
        
        answer = new ArrayList<>();
        dfs("ICN", 0, tickets.length);
        String[] res = new String[answer.size()];
        
        for(int i =0; i< answer.size(); i++){
            res[i] = answer.get(i);
        }
        
        return res;
    }
    
    public boolean dfs(String dep, int cnt, int N){
        answer.add(dep);
        if(cnt == N) return true;
        
        // info에 출발지 티켓이 있는 경우
        if(info.containsKey(dep) && !info.get(dep).isEmpty()){
            ArrayList<String> list = info.get(dep);
            
            for(int i=0; i<list.size(); i++){
                String next = list.get(i);
                list.remove(i);
                info.put(dep, list);
                
                boolean check = dfs(next, cnt+1, N);
                if(check){
                    return true;
                }
                list.add(next);
                Collections.sort(list);
                info.put(dep, list);
            }
            
        }
        
        // 마지막 원소 삭제
        answer.remove(answer.size()-1);
        return false;
    }
}