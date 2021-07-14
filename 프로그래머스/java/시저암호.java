public class 시저암호 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
    
            for(int i =0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch == 0x20) answer += " ";
                else {
                    int ascii_num = (int)ch+n;
                    if(Character.isUpperCase(ch)){
                        if(ascii_num > 90) ascii_num = ascii_num%90 +64;
                    } else if (Character.isLowerCase(ch)){
                        if(ascii_num > 122) ascii_num = ascii_num%122 + 96;
                    }
                    answer += (char)ascii_num;
                }
            }
            return answer;
        }
    }
}

//다른사람 풀이 %26

class Caesar {
    String caesar(String s, int n) {
        String result = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
        result += ch;
        }
        return result;
    }
}