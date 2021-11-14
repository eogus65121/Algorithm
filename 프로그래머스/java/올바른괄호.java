class Solution {
    boolean solution(String s) {
        int right = 0, left = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            if(s.charAt(i) == ')') {
                if(left <= right) return false;
                else right++;
            }
        }
        if(left == right) return true;
        else return false;
    }
}