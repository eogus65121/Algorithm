package 프로그래머스.java;
import java.util.Stack;

public class 같은숫자는싫어 {
    public class Solution {
        public int[] solution(int []arr) {
            int [] answer;
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for(int i = 1; i < arr.length; i++) {
                if(stack.peek() == arr[i]){
                    continue;
                } else {
                    stack.push(arr[i]);
                }
            }
            answer = new int[stack.size()];
            int index = 0;
            for(int k : stack) {
                answer[index++] = k;
            }
            
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}
