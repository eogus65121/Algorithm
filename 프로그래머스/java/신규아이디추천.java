import java.util.ArrayList;
import java.util.List;
class Solution3 {
    //id 3~15,,, - _ . 3개만 사용가능 단 . 은 처음과 끝, 연속 사용 x

    // 1 소문자로 변경
    // 2 연관없는 문자 제거
    // 3 중복..를 .로 변경
    // 4 처음과 끝에있는 . 제거
    // 5 1~4까지 진행 후 빈 문자열인지 확인
    // 15자를 제외한 오바한 글자 제거
    // 아이디 길이가 2 이하인지 확인
    public static String solution(String new_id) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        //1차
        new_id = new_id.toLowerCase();
        //2차
        for(int i=0; i < new_id.length(); i++){
            char char_id = new_id.charAt(i);
            if(Character.isDigit(char_id) || char_id == '-' || char_id == '_'|| char_id == '.' || (char_id >= 'a'&&char_id <= 'z')){
                list.add(char_id);
            }
        }
        //3차 String 값에서 처리하는도중 정규표현식에 대한 필요성을 크게 느낌 >> 결국 array list로 변경
        for(int i=0; i < list.size()-1; i++){
            if(list.get(i)=='.'){
                if(list.get(i+1) == '.') list.set(i, '+');
            }
        }
        List<Character> temp_list = new ArrayList<>();
        temp_list.add('+');
        list.removeAll(temp_list);  //removeAll을 사용하기 위해선 Collections 형태가 필요 즉 temp_list를 새롭게 선언해서 매개변수로 사용

        //4차
        while(list.contains('.')){
            if(list.size() == 1) {
                list.clear();
                break;
            }
            if(list.size() == 0) break;
            if(list.get(0) == '.') list.remove(0);
            if(list.get(list.size()-1) == '.') list.remove(list.size()-1);
            if(list.get(0) != '.' && list.get(list.size()-1) != '.') break;
        }

        // 5차
        if(list.size() == 0) list.add('a');
        // 6차, 7차
        if(list.size() >= 16){
            for(; list.size() > 15; ) list.remove(list.size()-1);
        } else if(list.size() <=2){
            for(; list.size() < 3;) list.add(list.get(list.size()-1));
        }
        //값 변경 후 변경 가능성이 있는 맨 뒷 index만 한번 더 체크
        if(list.get(list.size()-1) == '.') list.remove(list.size()-1);

        for(int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }
        System.out.println(answer);

        return answer;
    }
}