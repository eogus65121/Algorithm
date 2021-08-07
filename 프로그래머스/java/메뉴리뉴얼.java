import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class 메뉴리뉴얼 {

    class Solution {
        public String[] solution(String[] orders, int[] course) {
            List<String> answer_list = new ArrayList<>();
            List<String> comb_list = new ArrayList<>();

            for(int i : course){
                for(int j = 0; j < orders.length; j++){
                    if(orders[j].length() < i) continue;
                    else{
                        String [] arr_order = orders[j].split("");
                        int [] combArr = new int[arr_order.length];
                        Arrays.sort(arr_order);
                        Combination(combArr, arr_order.length, i, 0, 0, arr_order, comb_list);
                    }
                }
                select_menu(comb_list, orders);
                for(int n = 0; n < comb_list.size(); n++){
                    if(!comb_list.get(n).equals("0")) answer_list.add(comb_list.get(n));
                }
                comb_list.clear();
            }
            String[] answer = new String[answer_list.size()];
            for(int i = 0; i < answer_list.size(); i++) answer[i] = answer_list.get(i);
            Arrays.sort(answer);
            return answer;
        }

        private void select_menu(List<String> comb_list, String[] orders){
            List<Integer> max_list = new ArrayList<>();
            for(int i = 0; i < comb_list.size(); i++){
                int cnt = 0;
                boolean flag = true;
                for(int j = 0; j < orders.length; j++) {
                    for(String s : comb_list.get(i).split("")) {
                        if (orders[j].contains(s)) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) cnt++;
                }
                max_list.add(cnt);
            }
            if(max_list.size()!=0) {
                int max = Collections.max(max_list);
                for(int t = 0; t < max_list.size(); t++) {
                    if(max_list.get(t) < max || max < 2) comb_list.set(t, "0");
                }
            }
        }

        // n에서 r개 뽑기 combination 알고리즘
        private void Combination(int[] combArr, int n, int r, int index, int target, String [] arr, List<String>comb_list){
            if(r == 0){
                String str = "";
                for(int i =0; i<index; i++){
                    str += arr[combArr[i]];
                }
                if(!comb_list.contains(str)) comb_list.add(str);
                return;
            } else if(target == n){
                return;
            }else{
                combArr[index] = target;
                Combination(combArr, n, r-1, index+1, target+1, arr, comb_list);
                Combination(combArr, n, r, index, target+1, arr, comb_list);
            }
            return;
        }
    }
}
