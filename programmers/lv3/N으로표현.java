import java.util.*;

class Solution {
    
    class Cal{
        int n; // number 사용 횟수
        HashSet<Integer> set;
        
        public Cal(int n){
            this.n = n;
            set = new HashSet<>();
        }
    }
    
    // 계산값 저장해놓을 리스트
    ArrayList<Cal> cals;
    
    // 계산 함수
    public void calculate(int cnt, int n1, int n2, int N){
        HashSet hset = cals.get(cnt-1).set;
        int num = 0;
        while(cnt>0){
            num += N;
            N *= 10;
            cnt--;
        }
        hset.add(num);
        
        for(int n11: cals.get(n1-1).set){
            for(int n22: cals.get(n2-1).set){
                
                hset.add(n11+n22);
                hset.add(n11-n22);
                hset.add(n11*n22);
                if(n22!=0) hset.add(n11/n22);
                
            }
        }
        
    }
    
    public int solution(int N, int number) {
        // 숫자 하나 사용하는 거부터시작
        int cnt = 1;
        cals = new ArrayList<>();
        
        cals.add(new Cal(cnt));
        cals.get(0).set.add(N);
        
        // 만약 N이 number 이라면, return 1번
        if(N == number) return 1;
        
        // 최솟값이 8 이하일 때 까지
        while(cnt<=8){
            // 사용하는 N의 개수 증가
            cnt++;
            cals.add(new Cal(cnt));
            
            for(int i=cnt-1; i>=1; i--){
                // 사칙연산 계산해서 Cal의 arr에 add해주는 함수
                calculate(cnt, i, cnt-i, N);
            }
            
            if(cals.get(cnt-1).set.contains(number)) return cnt;
            
        }

        // 최솟값이 8 보다 크면 -1 return
        return -1;
    }
}