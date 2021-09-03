
class Solution {
    public int solution(String word) {
        int answer = 0;
        String [] alpha = {"A", "E", "I", "O", "U"};
        int [] value = {781, 156, 31, 6, 1};
        String [] split_word = word.split("");
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < alpha.length; j++){
                if(split_word[i].equals(alpha[j])){
                    answer += j * value[i] +1;
                }
            }
        }
        return answer;
    }
}