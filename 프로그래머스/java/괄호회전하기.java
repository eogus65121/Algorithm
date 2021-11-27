import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        for(int i = 0; i < list.size(); i++){
            if(chk(list)) answer++;
            list.addLast(list.get(0));
            list.removeFirst();
        }
        return answer;
    }
    private static boolean chk(LinkedList<Character> list){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if (!s.isEmpty()) {
                if(c == ')' && s.peek() == '(') s.pop();
                else if(c==']' && s.peek() == '[') s.pop();
                else if(c=='}' && s.peek() == '{') s.pop();
                else s.add(c);
            } else {
                s.add(c);
            }
        }
        if(s.size() == 0) return true;
        return false;
    }
}