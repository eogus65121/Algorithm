package 프로그래머스.java;
import java.util.Arrays;
import java.util.Comparator;

public class 문자열내림차순으로배치하기 {
    class Solution {
        public String solution(String s) {
            String[] arr = s.split("");
            Arrays.sort(arr, Comparator.reverseOrder());
            return String.join("", arr);
        }
    }
}
