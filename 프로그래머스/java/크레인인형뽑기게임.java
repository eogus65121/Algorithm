package 프로그래머스.java;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> stack = new Stack<>();
            int moves_size = moves.length;
            int value;
            int answer = 0;
            
            for(int k = 0; k<moves_size; k++) {
                int moves_num = moves[k];
                for(int i =0; i<board.length; i++) {
                    if(board[i][moves_num-1] < 1) {
                        continue;
                    } else {
                        value = board[i][moves_num-1];
                        try {
                            if(stack.peek() == value) {
                                stack.pop();
                                board[i][moves_num-1] = 0;
                                answer += 2;
                                break;
                            } else {
                                stack.push(value);
                                board[i][moves_num-1] = 0;
                                break;
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                            stack.push(value);
                            board[i][moves_num-1] = 0;
                            break;
                        }
                }
            }
            }
            return answer;
        }
    }
}

// 다시 풀어본 풀이

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int value = moves[i]-1;
            int move_value = 0;
            for(int j = 0; j<board.length; j++){
                if(board[j][value] != 0) {
                    move_value = board[j][value];
                    board[j][value] = 0;
                    break;
                }
            }
            if(move_value != 0) answer += stack_cal(stack, move_value);
        }
        return answer;
    }
    public int stack_cal(Stack<Integer> stack, int n){
        if(stack.isEmpty()) {
            stack.push(n);
            return 0;
        }
        else{
            if(stack.peek() == n) {
                stack.pop();
                return 2;
            }
            else{
                stack.push(n);
                return 0;
            }
        }
    }
}

