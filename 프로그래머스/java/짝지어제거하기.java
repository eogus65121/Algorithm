package 프로그래머스.java;
import java.util.Stack;
public class 짝지어제거하기 {
 class Solution{
	public int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		
		for(Character k : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek() == k) {
				stack.pop();
			} else {
				stack.push(k);
			}
		}
		if(stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}
		
		return answer;
	}
}
}
