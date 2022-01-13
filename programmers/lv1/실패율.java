import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 총 N개의 스테이지를 가지는 배열 생성
        int[] arr = new int[N+1];
        
        for(int s: stages){
            arr[s-1]++; // 각 스테이지에 머무르는 인원 수 조사
        }
        
        HashMap<Integer, Double> map = new HashMap<>();
        int ppl = stages.length;
        
        for(int i=0; i<arr.length-1; i++){
            double percent = (double)arr[i]/(double)ppl;
            ppl -= arr[i];
            map.put(i+1, percent);
            
            if(arr[i]==0)
                map.put(i+1, 0.0);
        }
        
        List<Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, Double>>() {
			// compare로 값을 비교
			public int compare(Entry<Integer, Double> obj1, Entry<Integer, Double> obj2) {
				// 내림 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}