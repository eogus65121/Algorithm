package 프로그래머스.java;

import java.util.*;

public class 보석쇼핑 {
    /** 해당 코드를 슬라이딩 윈도우를 사용해서 재풀이, 효율성 체크하기 **/
    class Solution {
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
