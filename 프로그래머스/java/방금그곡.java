import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<String[]> list = new ArrayList<>(); // title, playTime
        for(int i = 0; i < musicinfos.length; i++){
            String[] getData = new String[2];
            String[] s_info = musicinfos[i].split(",");
            int pTime = playTime(s_info[0], s_info[1]);
            String pMelody = playMelody(edit(s_info[3]), pTime);
            String edit_m = edit(m);
            if(pMelody.contains(edit_m)){
                getData[0] = s_info[2];
                getData[1] = Integer.toString(pTime);
                list.add(getData);
            }
        }
        if(list.size() == 0) return "(None)";
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            int time = Integer.parseInt(list.get(i)[1]);
            if(max < time){
                max = time;
                answer = list.get(i)[0];
            }
        }
        return answer;
    }

    private String playMelody(String melody, int playTime){
        StringBuilder sb = new StringBuilder();
        char[] melodyArr = melody.toCharArray();
        for(int i = 0; i < playTime; i++){
            sb.append(melodyArr[i % melody.length()]);
        }
        return sb.toString();
    }

    private int playTime(String start, String end){
        int min = Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2));
        int sec = Integer.parseInt(end.substring(3, 5)) - Integer.parseInt(start.substring(3, 5));
        sec += min*60;
        return sec;
    }
    private String edit(String melody){
        return melody.replaceAll("C#", "H").replaceAll("D#", "I").replaceAll("F#", "J").replaceAll("G#", "K").replaceAll("A#", "L");
    }
}