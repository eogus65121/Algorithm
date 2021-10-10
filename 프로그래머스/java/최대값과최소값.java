import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int max = -100000, min = 100000;
        while(st.hasMoreTokens()){
            int tokenValue = Integer.parseInt(st.nextToken());
            if(tokenValue > max) max = tokenValue;
            if(tokenValue < min) min = tokenValue;
        }
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}