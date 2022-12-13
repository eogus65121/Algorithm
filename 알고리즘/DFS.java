package 알고리즘;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    // 방문 노드 메모라이징
    static List<Integer> rtnList = new ArrayList<>();

    public static void main(String[] args) {
        boolean[] vst = new boolean[9];

        // 그래프 연결 상태를 2차원 배열로 표현
        // 인덱스는 각각의 노드 번호이며 0번 인덱스는 없음
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // dfs 실행
        dfs(vst, graph);

        // 결과 출력
        rtnList.stream().forEach(System.out::println);
    }

    public static  void dfs(boolean[] vst, int[][] graph){
        Stack<Integer> stack = new Stack<>();

        // 시작 전 시작 노드 넣기 (1번 노드로 시작), 방문 처리
        stack.push(1);
        vst[1] = true;

        while(!stack.isEmpty()){
            int nodeIdx = stack.pop();
            rtnList.add(nodeIdx);

            for(int linkedNode : graph[nodeIdx]){
                if(!vst[linkedNode]){
                    stack.push(linkedNode);
                    vst[linkedNode] = true;
                }
            }
        }

    }
}
