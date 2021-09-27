class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}

/*
// 다른 풀이
class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> h = new HashSet<>();
        for(int i : numbers) { h.add(i); }
        for(int i = 0 ; i < 10; i++){
            if(!h.contains(i)){
                answer += i;
            }
        }
        return answer;
    }
}
*/