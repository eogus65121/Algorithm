package 프로그래머스.java;
import java.util.*;

public class 베스트엘범 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> anwList = new ArrayList<>();
            Map<String, Integer> genTotCnt = getGenTotCnt(genres, plays);
            List<String> sortNameList = getSortGenList(genTotCnt);
            Map<String, int[]> genCntArr = getGenCnt(genres, plays, sortNameList);

            for(int i = sortNameList.size()-1; i >= 0; i--){
                for(int j : genCntArr.get(sortNameList.get(i))){
                    anwList.add(j);
                }
            }
            int[] answer = new int[anwList.size()];
            for(int i = 0; i < anwList.size(); i++){
                int time = anwList.get(i);
                for(int j = 0; j < plays.length; j++){
                    if(time == plays[j]){
                        answer[i] = j;
                        plays[j] = 0;
                        break;
                    }
                }
            }

            return answer;
        }
        private List<String> getSortGenList(Map<String, Integer> genTotCnt){
            List<String> rtnList = new ArrayList<>();
            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genTotCnt.entrySet());
            entryList.sort(((o1, o2) -> genTotCnt.get(o1.getKey()) - genTotCnt.get(o2.getKey())));
            for(Map.Entry<String, Integer> entry : entryList){
                rtnList.add(entry.getKey());
            }
            return rtnList;
        }

        // 장르별 재생 총 횟수
        private Map<String, Integer> getGenTotCnt(String[] genres, int[] plays){
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < genres.length; i++){
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            }
            return map;
        }

        // 장르마다의 각각의 재생 횟수, 정렬 후
        private Map<String, int[]> getGenCnt(String[] genres, int[] plays, List<String> genNameList){
            Map<String, int[]> map = new HashMap<>();
            for(int i = 0; i < genNameList.size(); i++){
                String genre = genNameList.get(i);
                List<Integer> cntList = new ArrayList<>();
                for(int j = 0; j < genres.length; j++){
                    if(genre.equals(genres[j])) cntList.add(plays[j]);
                }
                Collections.sort(cntList, Collections.reverseOrder());
                if(cntList.size() == 1) map.put(genre, new int[]{cntList.get(0)});
                else map.put(genre, new int[]{cntList.get(0), cntList.get(1)});
            }

            return map;
        }
    }
}
