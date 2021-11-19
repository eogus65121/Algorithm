//수정 이전 코드
class Solution {
    public int solution(int n) {
        int answer = 0;
        int n_len = one_cnt(Integer.toString(n, 2)); // 이진법 변환
        while(n_len != one_cnt(Integer.toString(n+1, 2))){
            n++;
        }
        answer = n+1;
        return answer;
    }
    private int one_cnt(String n){  // 1을 카운팅하는 코드
        int cnt = 0;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}

/*
// 이전 코드에서 bitCount만 추가한 코드
class Solution {
    public int solution(int n) {
        int n_len = Integer.bitCount(n);
        while(n_len != Integer.bitCount(n+1)){n++;}
        return n+1;
    }
}
*/