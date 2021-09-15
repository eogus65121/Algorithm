import java.util.*;

class Solution {
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer= new int[weights.length];
        Map<Integer, String> map = new HashMap<>();
        List<Integer> idxList = new ArrayList<>();
        double [][] winsCntArr = new double[weights.length][2];

        for(int i = 0; i < weights.length; i++){
            map.put(weights[i], head2head[i]);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < weights.length; i++){
            double [] temp = winsCnt(map, weights, i);
            winsCntArr[i][0] = temp[0];
            winsCntArr[i][1] = temp[1];
        }

        for(int i = 0; i < weights.length; i++){
            result.add(compWins(winsCntArr, idxList, weights)+1);
        }

        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static int compWins(double[][]winsCntArr, List<Integer>idxList, int[] weights){
        double max = 0.0;
        int idx=0;
        int weight = 0;
        for(int i = 0; i < winsCntArr.length; i++){
            if(!idxList.contains(i)) {
                if (winsCntArr[i][0] > max) {
                    max = winsCntArr[i][0];
                    idx = i;
                    weight = weights[i];
                } else if (winsCntArr[i][0] == max) {
                    if (winsCntArr[i][1] > winsCntArr[idx][1]) {
                        max = winsCntArr[i][0];
                        idx = i;
                        weight = weights[i];
                    }else if(winsCntArr[i][1] == winsCntArr[idx][1]){
                        if(weight < weights[i]){
                            weight = weights[i];
                            idx = i;
                        }
                    }
                }
            }
        }
        idxList.add(idx);
        return idx;
    }

    private static double[] winsCnt(Map<Integer, String>map, int[] weights, int index){
        double []result = new double[2];
        double W_cnt = 0.0;
        double L_cnt = 0.0;
        String str = map.get(weights[index]);
        for(int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == 'W') {
                W_cnt++;
                if (weights[index] < weights[j]) {
                    result[1]++;
                }
            }else if(str.charAt(j) == 'L'){
                L_cnt++;
            }
        }
        if(W_cnt == 0){
            result[0] = 0.0;   
        }else{
            result[0] = W_cnt/(W_cnt + L_cnt);
        }
        return result;
    }

}

// 싯팔 테케 뭐야 싯팔 ㅡㅡ 


/* 다른사람 풀이
import java.util.*;
class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        int[][] rank = new int[len][4];
        for(int i = 0; i < len; i++) {
            int w = weights[i], cnt = 0, win = 0, over = 0;
            for(int j = 0; j < len; j++) {
                char c = head2head[i].charAt(j);
                cnt += c == 'N' ? 0 : 1;
                win += c == 'W' ? 1 : 0;
                over += c == 'W' && weights[i] < weights[j] ? 1 : 0;
            }
            rank[i][0] = i + 1;
            rank[i][1] = (int)((double)win / cnt * 10000000);
            rank[i][2] = over;
            rank[i][3] = weights[i];
        }
        Arrays.sort(rank, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            if(a[2] != b[2]) return b[2] - a[2];
            if(a[3] != b[3]) return b[3] - a[3];
            return a[0] - b[0];
        });
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) answer[i] = (int)rank[i][0];
        return answer;
    }
}
*/