import java.util.*;

class Solution {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        List <Integer> meetingList=  new ArrayList<>();
        Map<Integer, Integer> meetingCntMap = new HashMap<>();

        for(int i : enter){ meetingCntMap.put(i, 0); }

        int cnt = 0;
        for(int i = 0; i < leave.length; i++){
            if(meetingList.contains(leave[i])){
                meetingList.remove(meetingList.indexOf(leave[i]));
                for(int t : meetingList){
                    meetingCntMap.put(t, meetingCntMap.getOrDefault(t, 0) +1);
                    meetingCntMap.put(leave[i], meetingCntMap.getOrDefault(leave[i], 0) +1);
                }
            }else{
                for(; cnt < enter.length; cnt++){
                    if(enter[cnt] == leave[i]){
                        for(int t : meetingList){
                            meetingCntMap.put(t, meetingCntMap.getOrDefault(t, 0) +1);
                            meetingCntMap.put(leave[i], meetingCntMap.getOrDefault(leave[i], 0) +1);
                        }
                        cnt++;
                        break;
                    }else{
                        meetingList.add(enter[cnt]);
                    }
                }
            }
        }
        for(int i = 1; i <= enter.length; i++){
            answer[i-1] = meetingCntMap.get(i);
        }

        return answer;
    }
}