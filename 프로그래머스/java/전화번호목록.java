public class 전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            try{
                for(int k = 0; k < phone_book.length-1; k++) {
                    for(int t = 0; t < phone_book.length; t++) {
                        if(phone_book[k].length() < phone_book[t].length()){
                            if(phone_book[k].equals(phone_book[t].substring(0, phone_book[k].length()))){
                                answer = false;
                                return answer;
                            }else {
                                continue;
                            }
                        }else {
                            continue;
                        }
                    }
                }
            }catch(IndexOutOfBoundsException e){
                e.getStackTrace();
            }
            return answer;
        }
    }
}

/* 다시 풀어본 풀이
import java.util.TreeMap;

class Solution{
    public static boolean solution(String[] phone_book){
        boolean answer = true;
        TreeMap<String, String> tm = new TreeMap<>(); // HashMap을 사용해도 무방
        for(String i : phone_book) tm.put(i, i); // map에 값 추가
        for(String str : phone_book){    // phone_book값을 가져와 해당 str 길이만큼 
            for(int i = 0; i < str.length(); i++){  // substring 후 contains로 여부 확인
                String comp = str.substring(0, i);
                if(tm.containsKey(comp)) return answer = false;
            }
        }
        return answer;
    }
}
*/