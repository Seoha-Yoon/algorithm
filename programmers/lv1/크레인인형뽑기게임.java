import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> stk = new Stack<>(); // 인형 담을 바구니
        
        for(int i = 0; i<moves.length; i++){// move 배열 길이 만큼 움직임
            for(int j=0; j<N; j++){
                if(board[j][moves[i]-1] != 0){
                    if(stk.isEmpty()){
                        stk.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                    }else{
                        if(stk.peek() == board[j][moves[i]-1]){
                            answer += 2;
                            stk.pop();
                            board[j][moves[i]-1] = 0;
                        }else{
                            stk.push(board[j][moves[i]-1]);
                            board[j][moves[i]-1] = 0;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}