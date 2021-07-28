public class 비밀지도 {
    class Solution {
        public String makeSharp(int n, int m) {
            if(n == 0) {
                if( m > 0) {
                    String str = "";
                    for(int i = 0; i < m; i++) {
                        str += " ";
                    }
                    return str;
                }
                else return "";
            }
            else {
                return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#"; 
            }
        }
        public String[] solution(int n, int [] arr1, int [] arr2) {
            String [] answer = new String[n];
            int [] secretMap = new int[n];
            for(int i = 0; i < n; i++) {
                secretMap[i] = arr1[i] | arr2[i];
                answer[i] = makeSharp(secretMap[i], n);
            }
            return answer;
        }
    }
}


// String으로 접근하여 푼 방법
class Solution10 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            String num1 = convert_binary(n, arr1[i]);
            String num2 = convert_binary(n, arr2[i]);
            String str = "";
            for(int j = 0; j < n; j++){
                if(num1.charAt(j) == num2.charAt(j) && num1.charAt(j) == '0') str += " ";
                else str += "#";
            }
            answer[i] = str;
        }
        return answer;
    }

    static String convert_binary(int n, int num){
        String str = Integer.toBinaryString(num);
        if(str.length() != n){
            while(true){
                str = "0" + str;
                if(str.length() == n) break;
            }
        }
        return str;
    }
}