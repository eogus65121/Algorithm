package 프로그래머스.java;

import java.util.*;
import java.util.stream.Collectors;

public class 귤고르기 {
    class Solution {
        // 크기와 상관없이 k개를 뽑고싶다
        // 가장 종류의 다양성을 작게 잡고싶다
        // 종류의 개수를 출력한다

        // 종류별 카운팅 = hashMap 사용
        // 가장 작은 수의 타켓부터 제거

        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> sizeMap = sizeCount(tangerine);
            List<Integer> sortedSizeList = sortedSize(sizeMap);

            int count = 0;

            for(int i = 0; i < sortedSizeList.size(); i++){
                if(count >= k) break;
                int num = sortedSizeList.get(i);

                int sizeKey = sizeMap.keySet().stream()
                        .filter(o -> sizeMap.get(o) == num)
                        .findFirst()
                        .get();
                count += sizeMap.get(sizeKey);
                answer++;
            }

            return answer;
        }

        private Map<Integer, Integer> sizeCount(int[] tangerine){
            Map<Integer, Integer> sizeMap = new HashMap<>();
            for(int i : tangerine){
                sizeMap.put(i, sizeMap.getOrDefault(i, 0) + 1);
            }
            return sizeMap;
        }

        private List<Integer> sortedSize(Map<Integer, Integer> map){
            return map.values().stream()
                    .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }

    }
}
