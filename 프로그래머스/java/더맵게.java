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
