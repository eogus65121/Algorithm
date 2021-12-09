class Solution {
    public String solution(int[] numbers, String hand) {
        // * = 9, 0 = 10, # = 11
        String answer = "";
        int[][] handPosition = {{3, 0}, {3, 2}}; // 0 = left, 1 = right;
        int[][] keyPad = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0) numbers[i] = 11;
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                handPosition[0] = num_position(numbers[i], keyPad);
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                handPosition[1] = num_position(numbers[i], keyPad);
            }else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 11) {
                int[] num_p = num_position(numbers[i], keyPad);
                String s = nearHand(num_p, handPosition);
                if(s.equals("S")){
                    if(hand.equals("left")) {
                        answer += "L";
                    }
                    if(hand.equals("right")) {
                        answer += "R";
                    }
                } else if(s.equals("R")) {
                    answer += "R";
                } else answer += "L";
                if(answer.charAt(answer.length()-1) == 'L'){
                    handPosition[0][0] = num_p[0];
                    handPosition[0][1] = num_p[1];
                }else if(answer.charAt(answer.length()-1) == 'R'){
                    handPosition[1][0] = num_p[0];
                    handPosition[1][1] = num_p[1];
                }
            }
        }
        return answer;
    }
    private String nearHand(int[] numPosition, int[][] handPosition){
        int left = Math.abs(handPosition[0][0] - numPosition[0]) + Math.abs(handPosition[0][1] - numPosition[1]);
        int right = Math.abs(handPosition[1][0] - numPosition[0]) + Math.abs(handPosition[1][1] - numPosition[1]);
        if(left < right) return "L";
        else if(left > right) return "R";
        else return "S";
    }
    private int[] num_position(int num, int[][] keyPad){
        int[] p = new int[2];
        for(int i = 0; i < keyPad.length; i++){
            for(int j = 0; j < keyPad[0].length; j++){
                if(keyPad[i][j] == num){
                    p[0] = i;
                    p[1] = j;
                    return p;
                }
            }
        }
        return p;
    }
}