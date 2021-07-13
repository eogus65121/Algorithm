package 프로그래머스.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;

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


// 속도가 더 빠른 코드
class Solution{
    public static String[] solution(String[] record) {
        ArrayList<String> chatting = new ArrayList<>();
        Map <String, String> uid_nickname = new HashMap<>();

        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String action = st.nextToken();
            String uid = st.nextToken();
            String nickname = "";
            if(!action.equals("Leave")) nickname = st.nextToken();

            if(action.equals("Enter")){
                uid_nickname.put(uid, nickname);
                String content = uid + "님이 들어왔습니다.";
                chatting.add(content);
            }else if(action.equals("Leave")){
                String content = uid + "님이 나갔습니다.";
                chatting.add(content);
            }else if(action.equals("Change")){
                uid_nickname.put(uid, nickname);
            }
        }

        int index = 0;
        String []answer = new String[chatting.size()];

        for(String str : chatting){
            String ss = uid_nickname.get(str.substring(0, str.indexOf("님이"))) + str.substring(str.indexOf("님이"));
            answer[index++] = ss;
        }

        return answer;
    }
}