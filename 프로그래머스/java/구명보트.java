import java.util.*;
class Solution {
    public  int solution(int[] people, int limit) {
        int answer = 0;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        Arrays.sort(people);
        for (int i : people) ad.add(i);
        while (!ad.isEmpty()) {
            if(ad.pollLast() + ad.peekFirst() <= limit) {
                ad.pollFirst();
                answer++;
            } else {
                answer++;
            }
            if(ad.size() == 1) {
                answer++;
                break;
            }
        }
        return answer;
    }
}