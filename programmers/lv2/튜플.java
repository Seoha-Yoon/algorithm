import java.util.*;

class Solution{
    
    public int[] solution(String s) {
        ArrayList<ArrayList<String>> set_list = new ArrayList<>();// string을 int[]로 분리해 저장할 리스트
        HashSet<Integer> set = new HashSet<>(); // 중복 검사
        ArrayList<String> strList = new ArrayList<>();

        String sb=""; // 각 집합에 해당하는 원소 리스트
        ArrayList<Integer> list = new ArrayList<>(); // 결과값 리턴할 어레이
        int count = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '{') count++;
            else if(s.charAt(i) == '}') count--;
            
            if(count == 2 && s.charAt(i) != ',' && s.charAt(i)!='{'){
                sb = sb.concat(Character.toString(s.charAt(i)));
            }else if(count ==1 && s.charAt(i) =='}'){
                strList.add(sb);
                set_list.add(strList);
                strList = new ArrayList<>();
                sb="";
            }else if(count ==0){
                break;
            }else if(s.charAt(i) == ',' && count ==2){
                strList.add(sb);
                sb ="";
            }
        }
        
        if(set_list.size() == 1){
            int[] answer = {Integer.parseInt(set_list.get(0).get(0))};
            return answer;
        }
        
        Collections.sort(set_list, new Comparator<ArrayList<String>>(){
            public int compare(ArrayList<String> s1, ArrayList<String> s2){
                return s1.size()-s2.size();
            }
        });
        
        for(int i=0; i<set_list.size();i++){
            for(int j=0; j<set_list.get(i).size();j++){
                int num = Integer.parseInt(set_list.get(i).get(j));
                if(set.isEmpty()){
                    set.add(num);
                    list.add(num);
                }else{
                    if(!set.contains(num)){
                        list.add(num);
                        set.add(num);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
}