package 프로그래머스.java;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

    class Solution {
        public String[] solution(String[] record) {
            HashMap <String, String> codeMap = new HashMap<>();
            HashMap <String, String> uidMap = new HashMap<>();
            codeMap.put("enter", "들어왔습니다.");
            codeMap.put("leave", "나갔습니다.");
            ArrayList<String> list = new ArrayList<>();
            
            for(String temp:record) {
                String[] str_split = temp.split(" ");
                String code = str_split[0];
                String uid = str_split[1];
                if(str_split.length > 2){
                    String name = str_split[2];
                    uidMap.put(uid, name);
                }
                if(!"Change".equalsIgnoreCase(code)){
                    list.add(code + " " + uid);
                }
            }
            String[] answer = new String[list.size()];
            for(int i =0; i< answer.length; i++) {
                String[] list_split = list.get(i).split(" ");
                String name_i = uidMap.get(list_split[1]);
                String code_i = list_split[0].toLowerCase();
                answer[i] = name_i + "님이 " + codeMap.get(code_i);
            }
            return answer;
        }
    }
}
