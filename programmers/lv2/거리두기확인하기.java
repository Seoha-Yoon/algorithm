import java.util.*;
class Solution {
    
    class People{
        int x, y;
        public People(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            String[] room = places[i];
            
            answer[i] = checkRoom(room);
        }
        return answer;
    }
    
    public int checkRoom(String[] room){
        ArrayList<People> arr = new ArrayList<>();
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(room[i].charAt(j) == 'P')
                    arr.add(new People(i, j));
            }
        }
        
        for(int i=0; i<arr.size(); i++){
            if(!checkMenhatan(arr, room)) return 0;
        }
        
        return 1;
    }
    
    public boolean checkMenhatan(ArrayList<People> people, String[] room){
        boolean[][] checked = new boolean[people.size()][people.size()];
        
        for(int i=0; i<people.size(); i++){
            for(int j=0; j<people.size(); j++){
                if(i==j || checked[i][j] || checked[j][i]) continue;
                People p1 = people.get(i);
                People p2 = people.get(j);
                
                if(Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y) <= 2){
                    if(p1.x == p2.x && room[p1.x].charAt((p1.y+p2.y)/2)=='X') continue;
                    if(p1.y == p2.y && room[(p1.x+p2.x)/2].charAt(p1.y)=='X') continue;
                    if(room[p2.x].charAt(p1.y)=='X'&& room[p1.x].charAt(p2.y)=='X') continue;
                    
                    return false;
                }
            }
        }
        
        return true;
    }
}