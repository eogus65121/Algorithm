package 프로그래머스.java;

class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        double d2 = Math.pow(d, 2);
        for(int i = 0; i <= d; i+= k){
            int top = (int)Math.sqrt(d2 - Math.pow(i, 2));
            answer += top/k + 1;
        }
        return answer;
    }
}