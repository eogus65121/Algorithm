package 프로그래머스.java;

import java.util.HashSet;

class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> dic1 = new HashSet<>();
        HashSet<Integer> dic2 = new HashSet<>();
        dic1.add(topping[0]);
        for (int i = 1; i < topping.length; i++) {
            dic2.add(topping[i]);
        }

        int index = 1;

        while (index < topping.length) {
            if (dic1.size() == dic2.size()) {
                answer++;
            }
            dic1.add(topping[index]);
            if (chkNum(index + 1, topping, topping[index])) {
                dic2.remove(topping[index]);
            }
            index++;
        }
        return answer;
    }

    private boolean chkNum(int index, int[] topping, int key) {
        for (; index < topping.length; index++) {
            if (topping[index] == key) return false;
        }
        return true;
    }
}

/*      효율성이 좋은 답안, 재확인 필요
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            int[] left = new int[10001], right = new int[10001];
            int ls = 0, rs = 0;
            for(int i : topping) right[i]++;
            for(int i : right) rs  += i > 0 ? 1 : 0;
            for(int i : topping) {
                right[i]--;
                if (right[i] == 0) rs--;
                if (left[i] == 0) ls++;
                left[i]++;
                if (rs == ls) answer++;
            }
            return answer;
        }
    }*/
