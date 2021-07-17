import java.util.ArrayList;
public class 주식가격 {
    class Solution {
        public static int[] solution(int[] prices) {
            ArrayList<Integer> list = new ArrayList<>();
            int[] answer = new int[prices.length];
            for(int index_f= 0; index_f < prices.length-1; index_f++) {
                int time = 0;
                int compA = prices[index_f];
                for(int index_b = index_f+1; index_b < prices.length; index_b++){
                    int compB = prices[index_b];
                    if(compA > compB) {
                        time++;
                        break;
                    } else {
                        time++;
                    }
                }
                list.add(time);
            }
            int index = 0;
            for(int k : list){
                answer[index++] = k;
            }
            
            return answer;
        }
    }
}
