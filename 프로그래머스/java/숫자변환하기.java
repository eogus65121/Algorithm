package 프로그래머스.java;

import java.util.*;

class 숫자변환하기 {
    public int count = Integer.MAX_VALUE;

    public int solution(int x, int y, int n) {
        HashSet <Integer> hs = new HashSet<>();
        HashSet <Integer> tempHs = new HashSet<>();
        hs.add(x);
        if(hs.contains(y)) return 0;
        int count = 0;
        while(true){
            if(tempHs.contains(y)) break;
            tempHs.clear();
            for(int i : hs){
                if(i * 2 <= y) tempHs.add(i * 2);
                if(i * 3 <= y) tempHs.add(i * 3);
                if(i + n <= y) tempHs.add(i + n);
            }
            if(tempHs.size() == 0) {
                count = -1;
                break;
            }
            count++;
            hs = (HashSet<Integer>)tempHs.clone();
        }
        return count;
    }
}