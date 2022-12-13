package 프로그래머스.java;
import java.util.*;

public class 디펜스게임 {

    class Solution {
        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i < enemy.length; i++){
                pq.add(enemy[i]);
                if(pq.size() > k){
                    n -= pq.poll();
                }
                if(n < 0){
                    return i;
                }
            }

            return enemy.length;
        }
    }
}
