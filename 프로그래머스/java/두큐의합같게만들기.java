package 프로그래머스.java;

import java.util.*;
class 두큐의합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum = 0, qHalf = 0;
        int count = 0;
        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            qHalf += queue1[i];
            q2.offer(queue2[i]);
            sum += queue1[i] + queue2[i];
        }
        int maxCount = queue1.length * 3;
        sum /= 2;

        while(qHalf != sum){
            if(count > maxCount){
                count = -1;
                break;
            }else{
                if(qHalf > sum){
                    qHalf -= q1.peek();
                    q2.offer(q1.poll());
                }else{
                    qHalf += q2.peek();
                    q1.offer(q2.poll());
                }
                count++;
            }
        }

        return count;
    }
}