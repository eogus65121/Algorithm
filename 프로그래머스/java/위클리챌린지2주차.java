import java.util.*;

class Solution {
    public static String solution(int[][] scores) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        int size = scores.length;
        int num = 0;
        for(int i = 0; i < scores[0].length; i++){
            for(int j = 0; j < size; j++) list.add(scores[j][i]);
            num = list.get(i);
            Collections.sort(list);
            if(num == list.get(0)){ // 최소
                if(num != list.get(1)) list.remove(0);
            }else if(num == list.get(size-1)){ // 최대
                if(num!= list.get(size-2)) list.remove(size-1);
            }
            int score = avg_score(list);
            answer += score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 50 ? "D" : "F";
            list.clear();
        }
        System.out.print(answer);
        return answer;
    }

    private static int avg_score(List<Integer> score){
        int sum = 0;
        for(int i : score) sum += i;
        return sum/score.size();
    }
}
