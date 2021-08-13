class Solution {
    public long solution(long price, long money, long count) {
        long answer = -1;
        long sum = 0;
        
        for(int i = 1; i <= count; i++){
            sum += i*price;
        }
        
        if(money - sum < 0) return sum-money;
        else return 0;
    }
}