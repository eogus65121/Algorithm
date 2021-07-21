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

// String에서 Integer 변환할 때 3진수로 변환
// Integer.parseInt(String, 3);
// 위의 풀이 list 선언 대신 String으로 나열 후 reverse + Integer.parseInt(String, 3); 사용
