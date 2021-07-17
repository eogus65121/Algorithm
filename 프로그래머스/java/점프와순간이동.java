public class 점프와순간이동 {
    public class Solution {
        public int solution(int n) {
            int ans = 0;
            int distance = n;
            while(distance!=0) {
                if(distance%2 ==0) {
                    distance = distance/2;
                } else {
                    distance = distance-1;
                    ans++;
                }
            }
                
            return ans;
        }
    }
}
