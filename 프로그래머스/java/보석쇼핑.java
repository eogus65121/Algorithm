package 프로그래머스.java;

import java.util.*;

public class 보석쇼핑 {

    /** 슬라이딩 윈도우를 활용한 풀이
     * 2차 풀이
     * 효율성 검사 good
     * */
    class Solution {
        //모든 종류의 보석을 1번 씩은 사야함
        //가장 짧은 구간
        public  int[] solution(String[] gems) {
            int[] answer = {};
            Set<String> s = new HashSet<>();
            //보석의 종류 개수 s.size()
            Arrays.stream(gems).forEach(o -> s.add(o));

            //슬라이딩 윈도우 카운팅을 위한 map
            Map<String, Integer> map = new HashMap<>();
            int len = Integer.MAX_VALUE;
            int start = -1;

            int fIdx = 0, rIdx = 0;
            map.put(gems[0], 1);
            if(map.size() == s.size()) return new int[]{1,1};

            while(true){
                if(map.size() < s.size()){
                    if(rIdx == gems.length-1) break;
                    rIdx++;
                    map.put(gems[rIdx], map.getOrDefault(gems[rIdx], 0) + 1);
                }
                else if(map.size() == s.size()){
                    if(len > rIdx - fIdx){
                        len = rIdx - fIdx;
                        start = fIdx;
                    }
                    if(map.get(gems[fIdx]) == 1){
                        map.remove(gems[fIdx]);
                    }else{
                        map.put(gems[fIdx], map.get(gems[fIdx]) -1);
                    }
                    fIdx++;
                }
            }
            return new int[]{start+1, start+1+len};
        }
    }


    /** 해당 코드를 슬라이딩 윈도우를 사용해서 재풀이, 효율성 체크하기 **/
    class Solution1 {
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
        public int[] solution(String[] gems) {
            HashSet<String> sCntGem = new HashSet<>();
            HashSet<String> sTotCnt = new HashSet<>();
            // 보석 전체 개수
            for(int i = 0; i < gems.length; i++){ sTotCnt.add(gems[i]);}
            int min = Integer.MAX_VALUE;
            int rstIdx = 0;

            for(int i = 0; i <= (gems.length-sTotCnt.size()); i++){
                int idx = i+1;
                int cnt = 0;
                for(int j = i; j < gems.length; j++){
                    sCntGem.add(gems[j]);
                    cnt++;
                    if(sCntGem.size() == sTotCnt.size()){
                        break;
                    }
                }
                if(min > cnt && sCntGem.size() == sTotCnt.size()){
                    min = cnt;
                    rstIdx = idx;
                }
                if(min == sTotCnt.size()) break;
                sCntGem.clear();
            }
            return new int[]{rstIdx, rstIdx+min-1};
        }
    }
}
