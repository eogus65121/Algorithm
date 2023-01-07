package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class 단어수학{
    // 대문자로 이루어진 알파벳
    // 알파벳 -> 숫자로 변환 and 총 합
    // 알파벳과 숫자는 1:1 매칭
    public static int[] alphaSet = new int[26];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1 = "AAA";
        String str2 = "AAA";
        String[] str = {str1, str2};

        for(int i = 0; i < 2; i++){
            String s = str[i];
            int digit = (int)Math.pow(10, s.length()-1);    // 알파벳의 자릿수를 구한다
            for(int j = 0; j < s.length(); j++){
                alphaSet[s.charAt(j) - 'A'] += digit;   // 알파벳 마다의 총 합을 넣어준다
                digit /= 10;
            }
        }

        Arrays.sort(alphaSet);
        int answer = 0;
        for(int i = alphaSet.length-1; i >= 17; i--){
            answer += alphaSet[i] * (i - 16);   // 알파벳의 총 합이 가장 큰 값 부터 9를 곱해서 더한다
        }
        System.out.println(answer);
    }
}