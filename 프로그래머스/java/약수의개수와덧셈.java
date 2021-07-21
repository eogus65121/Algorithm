public class 약수의개수와덧셈 {
    class Solution{
        public static int solution(int left, int right){
            int answer = 0;
    
            for( ; left<=right; left++){
                if(divisor(left) % 2 == 0) answer+=left;
                else answer -=left;
            }
    
            System.out.println(answer);
            return answer;
        }
    
        public static int divisor(int num){
            int cnt = 2;
            for(int j = 2; j < num; j++){
                if(num%j==0) cnt += 1;
            }
            System.out.println(cnt);
            return cnt;
        }
    }
}



// 에라토스테네스의 체 코드를 참고하여 수정한 코드
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(;left <= right; left++) answer += divisor(left);

        return answer;
    }
    public int divisor(int num){
        int sqrt_num = (int)Math.ceil(Math.sqrt(num));

        if(sqrt_num * sqrt_num == num) return (-1) * num;

        return num;
    }
}