package 프로그래머스.java;

import java.util.PriorityQueue;
import java.util.Collections;

public class 프린터 {    
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i : priorities) {
                pq.add(i);
            }
            while(!pq.isEmpty()) {
                for(int i =0; i < priorities.length; i++) {
                    if(pq.peek() == priorities[i]) {
                        pq.poll();
                        answer++;
                        if(location == i) {
                            pq.clear();
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
