package 프로그래머스.java;

import java.util.*;

public class 다단계칫솔판매 {

    class Solution {


        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] parentAmt = new int[enroll.length];

            Map<String, String> parentMap = new HashMap<>();
            Map<String, Integer> parentIdx = new HashMap<>();
            for(int i = 0; i < enroll.length; i++){
                parentMap.put(enroll[i], referral[i]);
                parentIdx.put(enroll[i], i);
            }

            for(int i = 0; i < seller.length; i++){
                nextParent(parentAmt, seller[i], parentMap, amount[i] * 100, parentIdx);
            }

            return parentAmt;
        }

        private void nextParent(int[] parentAmt, String sellPerson, Map<String, String> parentMap, int won, Map<String, Integer> parentIdx){
            if(won <= 0) return;
            else{
                parentAmt[parentIdx.get(sellPerson)] += won - nextPercent(won);
                if(parentMap.get(sellPerson).equals("-")) return;
                else nextParent(parentAmt, parentMap.get(sellPerson), parentMap, nextPercent(won), parentIdx);
            }
        }

        private int nextPercent(int price){
            return price/10;
        }
    }
}
