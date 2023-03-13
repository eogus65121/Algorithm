package 프로그래머스.java;

import java.util.Stack;

class 뒤에있는큰수 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[numbers.length-1]);
        answer[answer.length-1] = -1;

        for(int i = numbers.length-2; i >= 0; i--){
            int num = numbers[i];

            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }

            if(stack.isEmpty() || stack.peek() <= num){
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            stack.add(num);
        }

        return answer;
    }
}