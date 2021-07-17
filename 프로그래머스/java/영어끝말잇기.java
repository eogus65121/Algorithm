import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {

    public class Solution {
        
        public static int[] solution(int n, String[] words) {
            int [] answer = new int [2];
            Map <String, Integer> map = new HashMap<>();
            
            map.put(words[0], 0);
            try {
            for(int i =0; i < words.length-1; i++) {
                String x = words[i].substring(words[i].length()-1, words[i].length());
                String y = words[i+1].substring(0, 1);
                
                if(!x.equals(y) || map.containsKey(words[i+1])) {
                    if((i+2)%n == 0) {
                        answer[0] = n;
                        answer[1] = (i+2)/n;
                    
                        return answer;
                    }
                    else {
                        answer[0] = (i+2)%n;
                        answer[1] = ((i+2)/n)+1;
                    
                        return answer;
                    }
                }
                else {
                    map.put(words[i+1], i+1);
                    answer[0] = 0;
                    answer[1] = 0;
                }
            } 
            }catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            return answer;
            }
    }
}
