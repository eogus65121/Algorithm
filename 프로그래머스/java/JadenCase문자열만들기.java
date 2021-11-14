class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        int head = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && head == 0){ // 숫자가 아니고 첫번째 값인 경우
                sb.append(Character.toUpperCase(c));
                if(c != ' ') head++; // 처음이 공백인 경우 예외처리
            }else {
                sb.append(c);
                if(Character.isDigit(c)) head++;
                if(c == ' ') head = 0;
            }
        }
        return sb.toString();
    }
}