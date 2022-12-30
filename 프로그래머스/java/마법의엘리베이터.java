package 프로그래머스.java;

class 마법의엘리베이터 {
    // 현재 층 + 누른 층
    // 현재 층 + 누른 층 < 0 인 경우 움직이지 않는다
    // 가장 낮은 층 = 0; 현재 민수가 있는 층
    // greedy

    public int solution(int storey) {
        int answer = 0;
        int divNum = 10;
        int stLen = Integer.toString(storey).length();

        if(storey < 0) return 0;
        boolean isFive = false;

        while(Integer.toString(divNum).length() <= Integer.toString(storey).length()+1){
            int num = storey % divNum;
            int upDown = num / (divNum/10); // 한자리로 만들기
            if((num/(divNum/10)) > 5){
                storey += num;
                answer += 10-upDown;
            }else if(num/(divNum/10) < 5){
                storey -= num;
                answer += upDown;
            } else{
                int tempNum = storey % (divNum * 10);
                int tempUpDown = tempNum / (divNum * 100);
                if(tempNum/divNum > 4){
                    storey += num;
                    answer += 10-upDown;
                }else{
                    storey -= num;
                    answer += upDown;
                }
            }
            divNum *= 10;
        }

        return answer;
    }
}