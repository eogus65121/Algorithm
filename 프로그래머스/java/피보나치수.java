class Solution {
    public int solution(int n) {
        // F(n) = F(n-1) + F(n-2);
        int answer = 0;
        int num1 = 1; // num1 == 전수
        int num2 = 1; // num2 == 전전수
        for(int i = 2; i < n; i++){
            answer = (num1 + num2)%1234567;
            num1 = num2;
            num2 = answer;
        }
        return answer;
    }
}