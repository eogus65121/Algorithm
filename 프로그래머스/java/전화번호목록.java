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
