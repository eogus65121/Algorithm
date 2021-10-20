import java.util.*;
class Solution {
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        
        if(p.length() == 0) return sb.toString();
        
        int right = 0, left = 0;
        String u = "", v = "";
        
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') right++;
            if(p.charAt(i) == ')') left++;
            if(right == left){
                u += p.substring(0, i+1);
                v += p.substring(i+1);
                break;
            }
        }
        
        if(checkStr(u)){
            sb.append(u);
            sb.append(solution(v));
        }else{
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            for(int i = 1; i < u.length()-1; i++){
                if(u.charAt(i) == '(') sb.append(')');
                if(u.charAt(i) == ')') sb.append('(');
            }
        }
        
        return sb.toString();
    }
    
    private boolean checkStr(String s){
        StringBuilder b = new StringBuilder(s);
        while(b.toString().contains("()")){
            for(int i = 0; i < b.length()-1; i++){
                if(b.substring(i, i+2).equals("()")){
                    b.delete(i, i+2);
                }
            }
        }
        if(b.toString().equals("")){
            return true;
        }else{
            return false;
        }
    }
}