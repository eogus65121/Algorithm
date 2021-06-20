def solution(arr):
    answer = []
    min_a = min(arr)
    if len(arr) == 1:
        return [-1]
    else:
        arr.remove(min_a)
        answer = arr
    return answer