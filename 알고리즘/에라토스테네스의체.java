package 알고리즘;

/** 소수를 빨리 구할 수 있는 알고리즘 **/

public class 에라토스테네스의체 {
     class Solution {
        // 1~120 까지의 소수를 구해라
        public void main(String[] args) {
            // 120까지의 소수를 구하기 위해 해당 배열을 선언
            boolean[] prime = new boolean[121];
            // 구하고자 하는 숫자의 볌위
            int n = 120;
            // 0과 1은 소수가 될 수 없으므로 제외
            // false인 경우 소수이다.
            prime[0] = prime[1] = true;

            for(int i = 2; i*i <= n; i++){
                // prime[i]가 소수라면
                if(!prime[i]){
                    // prime[j] 소수가 아니다.
                    for(int j = i*i; j <= n; j+=i){
                        prime[j] = true;
                    }
                }
            }
            for(int i = 0; i <= n; i++){
                if(prime[i] == false) System.out.println(i);
            }
        }
    }
}
