import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++){
            // 1번
            if(one[i%one.length]==answers[i]) answer[0]++;
            // 2번
            if(two[i%two.length]==answers[i]) answer[1]++;
            // 3번
            if(thr[i%thr.length]==answers[i]) answer[2]++;
        }
        
        int[] temp = Arrays.copyOf(answer, answer.length);
        Arrays.sort(temp);
        int max = temp[2];
        ArrayList<Integer> first = new ArrayList<>();
        
        for(int i=0; i<answer.length; i++){
            if(answer[i]==max) first.add(i+1);
        }
        
        int[] res = new int[first.size()];
        for(int i=0; i<first.size(); i++){
            res[i] = first.get(i);
        }
        
        return res;
    }
}