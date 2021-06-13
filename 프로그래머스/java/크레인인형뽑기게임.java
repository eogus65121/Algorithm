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
