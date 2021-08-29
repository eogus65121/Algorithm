package 프로그래머스.java;
import java.util.PriorityQueue;

public class 더맵게 {
    class Solution {
        public int solution(int [] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int i : scoville) {
                heap.add(i);
            }
            while(!heap.isEmpty()){
                if(heap.peek() >= K) {
                    break;
                } else if (heap.size() <2 && heap.peek() < K){
                    answer = -1;
                    break;
                }
                else {
                    int mix_scov = (heap.poll() + (heap.poll() *2));
                    heap.add(mix_scov);
                    answer++;
                }
            }
            return answer;
        }
    }
}

/* 다시 풀어본 풀이
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);  // pq에 add시 자동 정렬
        int cnt=1;
        while(!pq.isEmpty()){     // 순서대로 뽑으면서 계산 후 다시 pq에 add
            int mix_value = pq.poll() + (pq.poll()*2);
            pq.add(mix_value);
            if(pq.peek() >= K) return cnt;
            if(pq.size() < 2) return -1;
            cnt++;
        }
        return -1;
    }
}
*/
