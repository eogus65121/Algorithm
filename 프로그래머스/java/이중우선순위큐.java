package 프로그래머스.java;
import java.util.*;

public class 이중우선순위큐 {

    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 최소
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // 최대
            int insert = 0, delete = 0;
            for(String s : operations){
                String[] split_s = s.split(" ");
                if(split_s[0].equals("I")){
                    pq1.add(Integer.parseInt(split_s[1]));
                    pq2.add(Integer.parseInt(split_s[1]));
                    insert++;
                }else{
                    if(insert <= delete) continue;
                    if(split_s[1].length() > 1){
                        pq1.poll();
                    }else{
                        pq2.poll();
                    }
                    delete++;
                }
            }
            if(insert <= delete) return new int[]{0, 0};
            int rst = 0;
            while(true){
                rst = pq1.poll();
                if(pq2.contains(rst)) break;
            }
            return new int[]{pq2.poll(), rst};
        }
    }
}
