import java.util.Stack;

public class 다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            
            for(int i = 0; i < dartResult.length(); i++){
                char temp = dartResult.charAt(i);
                            // 숫자 판별 '참'인경우 if문
                if(Character.isDigit(temp)) {
                                    // 10인 경우 10 push
                    if(temp == '1' && dartResult.charAt(i+1) == '0'){ 
                        stack.push(10);
                        i++;
                    } else{
                                            // 나머지 push
                        stack.push(Character.getNumericValue(temp));
                    }
                }else{
                    switch(temp){ // temp 값에 따른 switch문
                        case 'S':
                            break;
                        case 'D':
                            stack.push((int)(Math.pow(stack.pop(), 2)));
                            break;
                        case 'T':
                            stack.push((int)(Math.pow(stack.pop(), 3)));
                            break;
                        case '*':
                            int value = stack.pop()*2;
                            if(!stack.isEmpty()) stack.push(stack.pop()*2);
                            stack.push(value);
                            break;
                        case '#':
                            if(temp == '#') stack.push(stack.pop() * (-1));
                            break;
                    }
                }
            }
                    // stack에 값이 없을 때까지 합
            while(!stack.isEmpty()) answer += stack.pop();
                
            return answer;
        }
    }
}
