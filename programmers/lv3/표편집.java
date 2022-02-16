import java.util.*;
class Solution {

    class Row{
        int id;
        int before, next;
        boolean deleted;

        public Row(int id){
            this.id = id;
            deleted = false;
        }
    }

    boolean[] deleted;
    int cur;
    Row[] table;

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        cur = k; // 현재 선택된 행.

        Stack<Row> dStk = new Stack<>();

        // table 생성, 기본세팅
        table = new Row[n];
        for(int i=0; i<n; i++){
            table[i] = new Row(i);
            
            if(i==0){table[i].before = -1;}
            else{table[i].before = i-1;}
            
            if(i==n-1){table[i].next = -1;}
            else{table[i].next = i+1;}
            
        }
        
        int tableSize = n;

        // 명령어 처리
        for(String s: cmd){
            String[] arr = s.split(" ");
            String main = arr[0];
            int cnt = 0;
            Row curRow = table[cur];

            switch(main){
                case "U":
                    while(cnt<Integer.parseInt(arr[1])){
                        cur = curRow.before;
                        cnt++;
                        curRow = table[cur];
                    }
                    break;
                case "D":
                    while(cnt<Integer.parseInt(arr[1])){
                        cur = curRow.next;
                        cnt++;
                        curRow = table[cur];
                    }
                    break;
                case "C":
                    table[cur].deleted = true;
                    dStk.push(table[cur]);
                    int nextCur;
                    
                    if(table[cur].before == -1){
                        // cur이 첫번째 일 때,
                        table[table[cur].next].before = -1;
                        nextCur = table[cur].next;
                        cur = nextCur;
                    }else if(table[cur].next == -1){
                        // cur이 마지막일 때,
                        table[table[cur].before].next = -1;
                        nextCur = table[cur].before;
                        cur = nextCur;
                    }else{
                        // 보통의 경우
                        nextCur = table[cur].next;
                        table[table[cur].before].next = table[cur].next;
                        table[table[cur].next].before = table[cur].before;
                        cur = nextCur;
                    }
                    break;
                case "Z":
                    Row row = dStk.pop();
                    table[row.id].deleted = false;

                    if(table[row.id].before == -1){
                        table[table[row.id].next].before = row.id;
                    }else if(table[row.id].next == -1){
                        table[table[row.id].before].next = row.id;
                    }else{
                        table[table[row.id].before].next = row.id;
                        table[table[row.id].next].before = row.id;
                    }
                    
                    break;
            }
            //System.out.println("main= "+main+", cur= "+table[cur].id);
        }

        for(int i=0; i<n; i++){
            if(table[i].deleted) answer.append("X");
            else answer.append("O");
        }
        return answer.toString();
    }
}