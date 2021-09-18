import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        for(String arrS : arr){
            String []arrSSplit = arrS.split(",");
            for(String t : arrSSplit){
                map.put(t, map.getOrDefault(t, 0)+1);
            }
        }
        answer = new int[map.size()];
        int index = answer.length-1;
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for(Map.Entry<String, Integer> entry : entryList){
            answer[index--] = Integer.parseInt(entry.getKey());
        }
        return answer;
    }
}