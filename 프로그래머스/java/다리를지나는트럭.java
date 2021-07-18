import java.util.Queue;

public class 다리를지나는트럭 {
    class Solution {
        public static int solution(int bridge_length, int weight, int []truck_weights) {
            int answer = 0;
            int sum = 0;
            Queue <Integer> bridge_list = new LinkedList<>();
            for(int i : truck_weights) {
                while(true) {
                    if(bridge_list.isEmpty()) {
                        sum += i;
                        bridge_list.offer(i);
                        answer++;
                        break;
                    }else if (bridge_list.size() == bridge_length){
                        sum -= bridge_list.peek();
                        bridge_list.poll();
                    } else {
                        if(sum + i > weight) {
                            bridge_list.offer(0);
                            answer++;
                        } else {
                            sum += i;
                            bridge_list.offer(i);
                            answer++;
                            break;
                        }
                    }
                }

            }
            return answer + bridge_length;
        }
    }
}
