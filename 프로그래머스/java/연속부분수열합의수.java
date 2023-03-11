package 프로그래머스.java;

import java.util.HashSet;

class 연속부분수열의합의수 {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int value = 0;
                for(int n = j; n < j + i; n++){
                    // 회전수열 취급
                    value += elements[n % elements.length];
                }
                hs.add(value);
            }
        }
        return hs.size();
    }
}