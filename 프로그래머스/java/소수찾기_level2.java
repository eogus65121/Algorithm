import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> result_value = new ArrayList<>();
    static int count = 0;

    public static int solution(String numbers) {
        //char를 사용한 이유 = 숫자끼리의 계산이 아닌 숫자끼리의 계산이므로 char or string으로 조합하는 것이 효율적
        List<Character> list = new ArrayList<>();
        List<Character> result = new ArrayList<>();

        for(int i = 0; i < numbers.length(); i++){  //list에 모든 char로 잘라서 add
            list.add((numbers.charAt(i)));
        }

        for(int i = 0; i < numbers.length(); i++){
            //permutation == 순열 알고리즘
            permutation(list, result, numbers.length(), i+1);
        }
        return count;   //여러 test 값을 입력할 경우 전역변수인 count를 따로 0으로 초기화
    }

    // n개중 r개를 뽑는 순열코드; 기존 array를 사용한 알고리즘, swap를 사용한 다른 알고리즘 2가지
    public static void permutation(List<Character> list, List<Character> result, int n, int r) {
        if(r == 0){
            if(result.get(0) != '0'){
                String str = "";
                for(int i = 0; i < result.size(); i++){
                    str += result.get(i);
                }
                int convert_num = Integer.parseInt(str);
                if(check_prime(convert_num)){  //소수 판별하기
                    if(!result_value.contains(convert_num)){  //result_value, count는 전역변수
                        result_value.add(convert_num);
                        count++;
                    }
                }

            }
        }
        // 순열 permutation 재귀함수로 실행
        for(int i = 0; i < n; i++){ //기존 arr 코드를 list에 맞게 변경
            result.add(list.remove(i));
            permutation(list, result, n-1, r-1);
            list.add(i, result.remove(result.size()-1));
        }
    }

    //prime 여부를 구하는 코드
    public static boolean check_prime(int num){
        if(num < 2) return false;
        for(int i=2; i<=(int)(Math.sqrt(num)); i++){
            if(num%i == 0){
                if(i != num) return false;
            }
        }
        return true;
    }
}