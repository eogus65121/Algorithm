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