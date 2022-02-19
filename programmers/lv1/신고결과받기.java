import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> report_map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            report_map.put(id_list[i], new HashSet<>());
        }
        
        
        for(int i=0; i<report.length; i++){
            String[] content = report[i].split(" ");
            String a = content[0];
            String b = content[1];
            
            if(!report_map.get(a).isEmpty() && report_map.get(a).contains(b))
                continue;
            
            HashSet<String> set = report_map.get(a);
            set.add(b);
            count.put(b, count.getOrDefault(b, 0)+1);
        }
        
        for(int i=0; i<answer.length; i++){
            int cnt = 0;
            HashSet<String> set = report_map.get(id_list[i]);
            for(String s: set){
                if(count.get(s)>=k) cnt++;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}