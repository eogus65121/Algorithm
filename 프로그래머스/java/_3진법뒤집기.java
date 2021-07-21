import java.util.ArrayList;
import java.util.Collections;

public class _3진법뒤집기 {

    class Solution {
        public int solution(int n) {
            int answer = 0;
            ArrayList<Integer> list = new ArrayList<>();

            for(; n > 0; n/=3){
                list.add(n%3);
            }

            Collections.reverse(list);

            for(int i = 0; i < list.size(); i++){
                answer += Math.pow(3, i) * list.get(i);
            }
            return answer;
        }
    }
}
