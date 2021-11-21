import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int mvCnt = name.length()-1;
        int[] value = new int[name.length()];
        for(int i = 0; i < name.length(); i++) value[i] = upDownCnt(name.charAt(i));
        for(int i : value) answer += i;
        for(int i = 0; i < name.length(); i++){
            int index = i+1;
            while(index < name.length() && name.charAt(index) == 'A')
                index++;
            mvCnt = Math.min(mvCnt, (i * 2) + name.length() - index);
        }
        answer += mvCnt;
        return answer;
    }
    private int upDownCnt(char want_c){
        int want_ascii = (int) want_c;
        return Math.min(want_ascii-65, Math.abs(want_ascii-90)+1);
    }
}

/* 다른사람 코드
class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c:name.toCharArray())
            answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1;

        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }                
            min=Math.min(min,i+length-next+Math.min(i,length-next));
        }

        return answer+min;
    }
}

또다른 코드

class Solution {
public int solution(String name){
        int answer = 0, n = name.length(),
                leftOrRight = name.length() - 1;
        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);
            if(target <= 'N') answer += target - 'A';
            else answer += 'Z' - target + 1;
            while(next < n && name.charAt(next) == 'A') next++;
            leftOrRight = Math.min(leftOrRight, i + n - next + Math.min(i, n - next));
        }
        answer += leftOrRight;
        return answer;
    }
}
*/