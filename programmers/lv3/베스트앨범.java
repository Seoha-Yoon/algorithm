import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 정답을 저장할 list
        ArrayList<Integer> ansList = new ArrayList<>();
        
        // 장르에 따른 tot play 저장할 map
        HashMap<String, Integer> genreMap = new HashMap<>();
        // tot play에 따른 각 곡의 play 수를 저장할 map
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(genreMap.isEmpty() || !genreMap.containsKey(genres[i]))
                genreMap.put(genres[i], plays[i]);
            else
                genreMap.put(genres[i], genreMap.getOrDefault(genres[i], plays[i])+plays[i]);
        }
        
        for(int i=0; i<plays.length; i++){
            int tot = genreMap.get(genres[i]);
            HashMap<Integer, Integer> tmpMap;
            if(map.isEmpty() || !map.containsKey(tot))
                tmpMap = new HashMap<>();
            else
                tmpMap = map.get(tot);
            tmpMap.put(i, plays[i]);
            map.put(tot, tmpMap);
        }
        
        // sort 시작
        List<Map.Entry<Integer, HashMap<Integer, Integer>>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, HashMap<Integer, Integer>>>(){
            @Override
            public int compare(Map.Entry<Integer, HashMap<Integer, Integer>> o1, Map.Entry<Integer, HashMap<Integer, Integer>> o2) {
	        return o2.getKey() - o1.getKey();
            }
        });
        // 재생순서대로 
        for(Map.Entry<Integer, HashMap<Integer, Integer>> entry: entryList){
            HashMap<Integer, Integer> musicMap = entry.getValue();
            
            List<Map.Entry<Integer, Integer>> musicEntry = new ArrayList<>(musicMap.entrySet());
            musicEntry.sort(new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {            
                    if(o1.getValue().equals(o2.getValue()))
                        return o1.getKey() - o2.getKey();
	                return o2.getValue() - o1.getValue();
                }
            });
            
            int cnt = 0;
            for(Map.Entry<Integer, Integer> music: musicEntry){
                if(musicEntry.size() == 1) ansList.add(music.getKey());
                else{
                    if(cnt==2){
                        cnt = 0;
                        break;
                    }
                    ansList.add(music.getKey());
                    cnt++;
                }
            }
            
        }
        
        //int[] answer = new int[4];
        // 정답 list -> int array
        int[] answer = new int[ansList.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}