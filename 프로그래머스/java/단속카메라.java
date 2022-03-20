package 프로그래머스.java;
import java.util.*;

public class 단속카메라 {
    class Solution {
        // 최소 한 번은 카메라를 만나야한다.
        public int solution(int[][] routes) {
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

            int cnt = 1;
            int min = routes[0][1];
            for (int[] i : routes) {
                if(min < i[0]){
                    min = i[1];
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
