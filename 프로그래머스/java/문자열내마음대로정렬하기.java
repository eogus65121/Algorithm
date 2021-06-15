package 프로그래머스.java;

public class 문자열내마음대로정렬하기 {
    class Solution {
        public static String[] solution(String[] strings, int n) {
            String[] answer = {};
            for(int i = 0; i < strings.length-1; i++){
                for(int j = i+1; j < strings.length; j++){
                    String word1 = strings[i].split("")[n];
                    String word2 = strings[j].split("")[n];
                    if(word1.compareTo(word2) <0){
                        continue;
                    }else if(word1.compareTo(word2) == 0) {
                        if(strings[i].compareTo(strings[j]) > 0) {
                            String temp = strings[j];
                            strings[j] = strings[i];
                            strings[i] = temp;
                        }
                    }
                    else {
                        String temp = strings[j];
                        strings[j] = strings[i];
                        strings[i] = temp;
                    }
                }
            }
            return strings;
        }
    }
}
