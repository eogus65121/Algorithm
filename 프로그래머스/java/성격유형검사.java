package 프로그래머스.java;

import java.util.*;

class 성격유형검사 {
    // 성격유형 총 16가지
    // n개의 질문
    // 선택지 총 7개
    // 3, 2, 1, 0, 1, 2, 3 점수를 가진다
    final int[] score = {3, 2, 1, 0, 1, 2, 3}; // 점수
    final String[] personalTp = {"RT", "CF", "JM", "AN"};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < choices.length; i++){
            String suv = survey[i];
            if(choices[i] <= 3) map.put(suv.charAt(0), map.getOrDefault(suv.charAt(0), 0) + score[choices[i]-1]);
            else map.put(suv.charAt(1), map.getOrDefault(suv.charAt(1), 0) + score[choices[i]-1]);
        }

        for(int i = 0; i < 4; i++){
            answer += returnMaxStr(map, personalTp[i].charAt(0), personalTp[i].charAt(1));
        }

        return answer;
    }

    public String returnMaxStr(Map<Character, Integer> map, char c1, char c2){
        if(map.getOrDefault(c1, 0) >= map.getOrDefault(c2, 0)) return String.valueOf(c1);
        else return String.valueOf(c2);
    }
}