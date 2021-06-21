package 프로그래머스.java;

public class 콜라츠추측 {
    class Solution {
        public int solution(int num) {
            int answer = 0;
            long temp = (long)num;
            if(num == 1) {
                return 0;
            }
            for(int i = 0; i < 501; i++) {
                answer+=1;
                if(temp % 2 == 0) {
                    temp = temp/2;
                    if(temp == 1)    {break;}
                }
                else {temp = (temp*3 +1);}
            }
            if(answer > 500)    {return -1;}
            return answer;
        }
    }
}
