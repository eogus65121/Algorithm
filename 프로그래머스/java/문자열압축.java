public class 문자열압축 {
    //내 풀이
    class Solution1 {
        public int solution(String s) {
            int answer = s.length();
            for(int i = 1; i <= s.length()/2; i++){
                String str = "";
                String pattern = "";
                int count = 1;
                for(int j = 0; j < s.length()/i; j++){
                    String comp_str = s.substring((i*j), (i*j)+i);
                    if(pattern.equals(comp_str)){
                        count++;
                        continue;
                    }
                    if(count >1) str += count + pattern;
                    else str += pattern;
                    pattern = comp_str;
                    count = 1;
                }
                if(count > 1) str += count + pattern;
                else str += pattern;
    
                if(s.length() % i != 0) {
                    str += s.substring(s.length() - (s.length() % i));
                }
                answer = Math.min(str.length(), answer);
            }
            return answer;
        }
    }



    //재귀를 사용한 다른 풀이
    class Solution2 {

        public static int solution(String s) {
            int answer = 0;
    
            for(int i = 1; i <= (s.length()/2)+1; i++){
                int result = getSplitedLength(s, i, 1).length();
                answer = i==1 ? result : (answer>result?result:answer);
            }
            return answer;
        }
    
        public static String getSplitedLength(String s, int n, int repeat){
            if(s.length() < n) return s;
            String result = "";
            String preString = s.substring(0, n);
            String postString = s.substring(n, s.length());
    
            if(!postString.startsWith(preString)){
                if(repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
                return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
            }
            return result += getSplitedLength(postString, n, repeat+1);
        }
    }


    //효율성이 높은 다른 풀이
    class Solution3 {
        public static int solution(String s){
            int min = s.length();
            int len = s.length()/2+1;
            for(int i = 1; i < len; i++){
                String before = "";
                int sum = 0;
                int cnt = 1;
                for(int j = 0; j < s.length();){
                    int start = j;
                    j = (j+i > s.length()) ? s.length():j+i;
                    String temp = s.substring(start, j);
                    if(temp.equals(before)){
                        cnt++;
                    }else{
                        if(cnt != 1){
                            sum += (int)Math.log10(cnt)+1;
                        }
                        cnt = 1;
                        sum += before.length();
                        before = temp;
                    }
                }
                sum+=before.length();
                if(cnt!=1){
                    sum += (int)Math.log10(cnt)+1;
                }
                min = (min > sum) ? sum:min;
            }
            return min;
        }
    }
}
