import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<String[]> list = new ArrayList<>();
        for(int i  = 0; i < files.length; i++){
            String[] file = name_analysis(files[i]);
            list.add(file);
        }

        sort_name(list);

        int index = 0;
        for(String [] s : list){
            String str = "";
            for(String ss : s){
                str += ss;
            }
            answer[index] = str;
            index++;
        }
        return answer;
    }
    
    private String[] name_analysis(String str){
        String head = "", num = "", tail = "";
        int index = 0;
        for(; index < str.length(); index++){ //head
            if(Character.isDigit(str.charAt(index))){
                break;
            }
            head += str.charAt(index);   
        }
        for(; index < str.length(); index++){ //number
            if(!Character.isDigit(str.charAt(index)) || num.length() == 5){
                break;
            }
            num += str.charAt(index);
        }
        for(; index < str.length(); index++){ //tail
            tail += str.charAt(index);
        }
        String[] file_analysis = {head, num, tail};
        return file_analysis;
    }
    
    private void sort_name(List<String[]> list){
        for(int i = 1; i < list.size(); i++){
            for(int j = 0; j < list.size()-i; j++){
                String head1 = list.get(j)[0].toLowerCase();
                String head2 = list.get(j+1)[0].toLowerCase();
                if(head1.compareTo(head2) > 0){
                    Collections.swap(list, j, j+1);
                }else if(head1.compareTo(head2) == 0){
                    if(Integer.parseInt(list.get(j)[1]) > Integer.parseInt(list.get(j+1)[1])){
                        Collections.swap(list, j, j+1);
                    }
                }
            }
        }
    }
}


// 이전에 실패했던 코드 왜 실패한지 모르겠음 ;;
/** 
class Solution {
    public String[] solution(String[] files) {
        String[] sort_files = num_sort(alpha_sort_dict(files));
        return sort_files;
    }
    private String[] alpha_sort_dict(String[] files) {
        for(int i = 1; i < files.length; i++){
            for(int j = 0; j < files.length-i; j++){
                String head1 = files[j].substring(0, cntIndex(files[j], 0, 1)).toLowerCase();
                String head2 = files[j+1].substring(0, cntIndex(files[j+1], 0, 1)).toLowerCase();
                if(head1.replaceAll("[^a-z]", "").compareToIgnoreCase(head2.replaceAll("[^a-z]", "")) > 0){
                    String temp = files[j+1];
                    files[j+1] = files[j];
                    files[j] = temp;
                }
            }
        }
        return files;
    }

    private String[] num_sort(String[] files){
        for(int i = 1; i < files.length; i++){
            for(int j = 0; j < files.length-i; j++){
                String head1 = files[j].substring(0, cntIndex(files[j], 0, 1)).toLowerCase();
                String head2 = files[j+1].substring(0, cntIndex(files[j+1], 0, 1)).toLowerCase();
                if(head1.equals(head2)){
                    int num1 = Integer.parseInt(files[j].substring(head2.length(), cntIndex(files[j], head2.length(), 2)));
                    int num2 = Integer.parseInt(files[j+1].substring(head2.length(), cntIndex(files[j+1], head2.length(), 2)));
                    if(num1 > num2){
                        String temp = files[j+1];
                        files[j+1] = files[j];
                        files[j] = temp;
                    }
                }
            }
        }
        return files;
    }
    private int cntIndex(String s, int index, int flag){
        if(flag == 1){
            for(int i =index; i < index+5; i++){
                if(i >= s.length()) return i;
                if(Character.isDigit(s.charAt(i))) return i;
            }
        }
        if(flag == 2){
            for(int i =index; i < index+5; i++){
                if(i >= s.length() || i == index+4) return i;
                if(!Character.isDigit(s.charAt(i))) return i;
            }
        }
        return 0;
    }
}
*/