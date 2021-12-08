class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            long value = numbers[i] % 2 == 0 ? numbers[i] + 1 : conv(numbers[i]);
            answer[i] = value;
        }
        return answer;
    }
    private static long conv(long num){
        String num_str = "0" + Long.toBinaryString(num);
        StringBuilder sb = new StringBuilder(num_str);
        String temp = sb.reverse().toString();
        sb.setLength(0);
        sb.append(temp.replaceFirst("10", "01")).reverse();
        return Long.parseLong(sb.toString(), 2);
    }
}