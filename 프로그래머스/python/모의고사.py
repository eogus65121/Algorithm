def solution(answers):
    supo = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    s = [0] * len(supo)
    answer = []
    
    for q, a in enumerate(answers):
        for i, v in enumerate(supo):
            if a == v[q % len(v)]:
                s[i] += 1

    for i, v in enumerate(s):
        if v == max(s):
            answer.append(i+1)
            
    return answer