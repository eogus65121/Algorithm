import java.util.*;

public class 주차요금계산 {

    class Solution {
        public int[] solution(int[] fees, String[] records) {
            Map<String, Integer> inOutMap = new HashMap<>();
            Map<String, Integer> fTimeMap = new HashMap<>();
            List<String> carNum = new ArrayList<>();
            // 시간 계산
            for(int i = 0; i < records.length; i++){
                String[] pData = records[i].split(" ");
                if(!carNum.contains(pData[1])) carNum.add(pData[1]);
                calcTime(pData, inOutMap, fTimeMap, false);
            }
            // 주차장에서 23:39까지 나가지 않은 경우 별도 처리
            if(inOutMap.size() != 0){
                Set<String> key = inOutMap.keySet();
                for(String s : key){
                    String[] pData = {"23:59", s};
                    calcTime(pData, inOutMap, fTimeMap, true);
                }
            }
            int[] answer = new int[carNum.size()];
            Collections.sort(carNum);
            for(int i = 0; i < carNum.size(); i++){
                answer[i] = calcFee(carNum.get(i), fees, fTimeMap);
            }

            return answer;
        }
        // 시간 계산
        private void calcTime(String[] pData, Map<String, Integer> inOutMap, Map<String, Integer> fTimeMap, boolean flag){
            if(inOutMap.containsKey(pData[1])){ // 주차장에 차량이 이미 있는 상태
                int t = convMin(pData[0]) - inOutMap.get(pData[1]);
                fTimeMap.put(pData[1], fTimeMap.getOrDefault(pData[1], 0) + t);
                if(flag == false) inOutMap.remove(pData[1]);
            }else{
                inOutMap.put(pData[1], convMin(pData[0]));
            }
        }
        // 분 단위 시간 변환
        private int convMin(String time){
            return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        }
        // 가격 계산
        private int calcFee(String car, int[] fees, Map<String, Integer> fTimeMap){
            int time = fTimeMap.get(car);
            if(time > fees[0]){
                return (int)Math.ceil((double)(time-fees[0]) / fees[2]) * fees[3] + fees[1];
            }else{
                return fees[1];
            }
        }
    }

    /** 참고할 다른 사람 코드 */
/*
    class Solution {

        public int timeToInt(String time) {
            String temp[] = time.split(":");
            return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        }
        public int[] solution(int[] fees, String[] records) {

            TreeMap<String, Integer> map = new TreeMap<>();

            for(String record : records) {
                String temp[] = record.split(" ");
                int time = temp[2].equals("IN") ? -1 : 1;
                time *= timeToInt(temp[0]);
                map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
            }
            int idx = 0, ans[] = new int[map.size()];
            for(int time : map.values()) {
                if(time < 1) time += 1439;
                time -= fees[0];
                int cost = fees[1];
                if(time > 0)
                    cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

                ans[idx++] = cost;
            }
            return ans;
        }
    }

 */
}
