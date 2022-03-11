class Solution {
    class Condition{
        char me, you, con;
        int distance;
        
        public Condition(char me, char you, char con, int distance){
            this.me = me;
            this.you = you;
            this.con = con;
            this.distance =distance;
        }
    }
    
    Condition[] conditions;
    int cnt;
    char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        conditions = new Condition[n];
        
        for(int i=0; i<n; i++){
            String str = data[i];
            
            conditions[i] = new Condition(str.charAt(0), str.charAt(2), str.charAt(3), str.charAt(4)-'0');
        }
        
        cnt = 0;
        boolean[] visited = new boolean[8];
        comb(visited, "");
        
        return cnt;
    }
    
    public void comb(boolean[] visited, String name){
        if(name.length() == 8){
            if(checkCondition(name)){
                cnt++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] =true;
                comb(visited, name+characters[i]);
                visited[i] =false;
            }
        }
    }
    
    public boolean checkCondition(String str){
        boolean flag =true;
        
        for(int i=0; i<conditions.length; i++){
            Condition cond = conditions[i];
            
            char me = cond.me;
            char you = cond.you;
            
            int me_in = str.indexOf(me);
            int you_in = str.indexOf(you);
            
            if(cond.con == '=' && !(Math.abs(me_in-you_in) == cond.distance+1)){
                return false;
            }else if(cond.con == '>' && !(Math.abs(me_in-you_in) > cond.distance+1)){
                return false;
            }else if(cond.con == '<' && !(Math.abs(me_in-you_in) < cond.distance+1)){
                return false;
            }
        }
        return flag;
    }
}