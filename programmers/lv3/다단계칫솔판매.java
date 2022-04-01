import java.util.*;
class Solution {
    
    class Node{
        String parent;
        ArrayList<String> child;
        int profit;

        public Node(String parent){
            this.parent = parent;
            child = new ArrayList<>();
            profit = 0;
        }
    }

    HashMap<String, Node> tree;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        tree = new HashMap<>();
        
        // init tree;
        init(enroll, referral);

        // calculate profit
        for (int i = 0; i < seller.length; i++) {
            calculate(seller[i], amount[i]*100);
        }

        // change map to return type
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = tree.get(enroll[i]).profit;
        }

        return answer;
    }

    // 시간 초과?
    private void calculate(String seller, int cost) {
        Node cur  = tree.get(seller);
        while(true){
            int next = (int)(cost * 0.1);
            cur.profit += cost-next;
            cost = next;
            // 분배할 수익이 더이상 없다면... 멈춰도 됨
            if(cost == 0) return;
            if(cur.parent.equals("-")) return;
            cur = tree.get(cur.parent);
        }
    }

    private void init(String[] enroll, String[] referral) {
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], new Node(referral[i]));
        }
    }
}
