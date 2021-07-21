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



//효율성이 증가한 상태의 코드
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int s = (int)Math.ceil(Math.sqrt(left));
        int ss = s * s;
        for (int i = left; i <= right; i++) {
            if (i == ss) {
                answer -= i;
                s++;
                ss = s * s;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}