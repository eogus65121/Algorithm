import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<int[]> list = new ArrayList<>();
        int tileCnt = brown + yellow;

        for(int i = 2; i <= Math.sqrt(tileCnt); i++){
            int[] temp = new int[2];
            if(tileCnt%i == 0){
                temp[1] = i;
                temp[0] = tileCnt/i;
                list.add(temp);
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(brown == (list.get(i)[0] + list.get(i)[1] - 2) * 2){
                answer[0] = list.get(i)[0];
                answer[1] = list.get(i)[1];
                break;
            }
        }

        return answer;
    }
}