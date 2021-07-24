public class 타겟넘버 {
    class Solution {
        public int cnt = 0;
        public int solution(int[] numbers, int target) {
            int start = 0; // 배열 방문 처음 위치 index 값
            boolean [] visited = new boolean[numbers.length];
    
            for(int i = 0; i < numbers.length; i++){ // i=0 일때 한개 선택 ++++
                combination(numbers, visited, start, numbers.length, i, target); //조합 알고리즘
            }
            return cnt;
        }

        // boolean == 방문 여부 체크 arr, start == arr 시작 index
        // n == 전체 개수, r == 뽑는 개수
        void combination(int []numbers, boolean []visited, int start, int n, int r, int target) {
            if(r == 0){ //r == 0 combination 알고리즘 한 루틴 끝
                int sum = 0;
                for(int j = 0; j < n; j++){
                    //true 값 == 내가 뽑은 index 값 (-)
                    //false 값 == 내가 뽑지 않은 index 값 (+)
                    if(visited[j] == true) sum -= numbers[j];
                    else sum += numbers[j];
                }
                if(sum == target) cnt++;
                return;
            }

            for(int i = start; i < n; i++){
                visited[i] = true;  // 뽑은 index == true 값으로 변경
                combination(numbers, visited, i+1, n ,r-1, target); //재귀
                visited[i] = false; // 뽑았던 index == false
            }
        }
    }
}

//다른 사람 풀이

class Solution1 { // dp 사용
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);  
        return answer;
    }
                            //0       0   
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1; // target 값과 같을 때 cnt ++ 되는 값
            }
            return 0;
        }
        //dp를 사용하여 + 일 때와 - 일 때를 모두 구함, n == numbers.length가 될 때까지 
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target); 

        //주의!! numbers의 모든 값이 동일하기 때문에 사용할 수 있는 방법
    }
}