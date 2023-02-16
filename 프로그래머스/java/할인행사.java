package 프로그래머스.java;

import java.util.*;

class 할인행사 {
    // 일정금액 이상 구매 시 10일간 회원 자격
    // 회원 대상 매일 한 가지 제품 할인 행사
    // 할인 제품 하나에 하나씩 구매 가능
    // 효율 최대치 구매 방법
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i = 0; i <= discount.length-10; i++){
            String[] discArr = Arrays.copyOfRange(discount, i, i+10);
            Map<String, Integer> discMap = new HashMap<>();
            for(String item : discArr){
                discMap.put(item, discMap.getOrDefault(item, 0) + 1);
            }

            if(want.length != discMap.size()) continue;

            boolean flag = true;

            for(int w = 0; w < want.length; w++){
                if(!discMap.containsKey(want[w]) || discMap.get(want[w]) != number[w]) {
                    flag = false;
                    break;
                }
            }

            if(flag == true) answer++;
        }

        return answer;
    }
}