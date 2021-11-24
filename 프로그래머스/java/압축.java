import java.util.*;
class Solution {
     public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map <String, Integer> dic = new HashMap<>();
        int index = 1, value = 26;
        for(int i = 65; i < 91; i++) { dic.put(Character.toString((char)i), index++);}
        String[] split_msg = msg.split("");
        index = 0;
        while(true){
            String str = "";
            int cnt = chkDic(dic, split_msg, index);
            for(int i = index; index < i + cnt; index++){
                str += split_msg[index];
            }
            list.add(dic.get(str));
            if(index > msg.length()-1) break;
            str += split_msg[index];
            dic.put(str, ++value);
        }
         int[] answer = new int[list.size()];
         for(int i = 0; i < answer.length; i++){
             answer[i] = list.get(i);
         }

        return answer;
    }
    private int chkDic(Map <String, Integer> dic, String[] msg, int index){
        int cnt = 0;
        int temp = index;
        String str = msg[temp];
        while(dic.getOrDefault(str, 0) != 0) {
            if(temp == msg.length-1){
                cnt++;
                break;
            }
            str+=msg[++temp];
            cnt++;
        }
        return cnt;
    }
}