import java.util.Stack;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        expression = expression.replaceAll("\\*", " * ").replaceAll("-", " - ").replaceAll("\\+", " + ");
        String[] operators = {"*", "+", "-"};

        for(int i = 0; i <= 5; i++){
            if(i == 2) operators = swap(operators);
            answer = Math.max(Math.abs(Long.parseLong(priCalculator(operators, expression, i))), answer);
        }

        return answer;
    }

    private String priCalculator(String[] operators, String expression, int index){
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder(expression);
        for(int i = 0; i < 3; i++){
            String operator = operators[(i+index) % 3];
            String temp = sb.toString();
            if(!temp.contains(operator)) continue;
            else{
                String[] exps = temp.split(" ");
                for(int j = 0; j < exps.length; j++){
                    if(exps[j].equals(operator)){
                        if(exps[j].equals("*")) {
                            s.add(Long.toString(Long.parseLong(s.pop()) * Long.parseLong(exps[j+1])));
                        }
                        else if(exps[j].equals("+")) {s.add(Long.toString(Long.parseLong(s.pop()) + Long.parseLong(exps[j+1])));}
                        else if(exps[j].equals("-")) {s.add(Long.toString(Long.parseLong(s.pop()) - Long.parseLong(exps[j+1])));}
                        j++;
                    }else{
                        s.add(exps[j]);
                    }
                }
                sb.setLength(0);
                while(!s.isEmpty()){
                    sb.insert(0, " "+s.pop());
                }
            }
        }
        return sb.toString().replaceAll(" ", "");
    }

    private String[] swap(String[] arr){
        String temp = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;
        return arr;
    }
}

// 다른 사람 코드 (효율이 더 좋음)
/*
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    static long max = 0;

    public static ArrayList<Long> nums = new ArrayList<>();//expression 숫자들
    public static ArrayList<String> opers = new ArrayList<>();//expression 연산자들

    static void permutation(String[] prior, int depth, int n) {
        if (depth == n) {
            ArrayList<Long> temp_nums = new ArrayList<>();
            ArrayList<String> temp_opers = new ArrayList<>();

            for(int i = 0; i<nums.size(); i++){
                temp_nums.add(nums.get(i));
                if(i != nums.size()-1){
                    temp_opers.add(opers.get(i));
                }

            }
            for(int i = 0; i<3; i++){
                for(int j = 0; j<temp_opers.size(); j++){
                    if(temp_opers.get(j).equals(prior[i])){
                        long a = temp_nums.get(j);
                        long b = temp_nums.get(j+1);

                        temp_nums.remove(j+1);
                        temp_nums.remove(j);
                        temp_opers.remove(j);
                        temp_nums.add(j,cal(a,b,prior[i]));
                        j--;
                    }
                }
            }

            long num = Math.abs(temp_nums.get(0));
            if(max < num){
                max = num;

            }
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(prior, depth, i);
            permutation(prior, depth + 1, n);
            swap(prior, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    static long cal(long a, long b, String str){
        if(str.equals("+")){
            return a+b;
        }
        else if(str.equals("-")){
            return a-b;
        }
        return a*b;
    }
    public long solution(String expression) {

        String[] prior = {"+", "-", "*"};
        String[] num = expression.split("[^0-9]");
        String[] sign = expression.split("[0-9]+");
        for(int i = 0; i<num.length; i++){
            nums.add(Long.parseLong(num[i]));
            if(i != 0){
                opers.add(sign[i]);
            }
        }
        permutation(prior, 0, 3);

        return max;
    }
}
*/