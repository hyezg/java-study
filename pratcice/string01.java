//프로그래머스 문자열 뒤집기 문제 다른 사람 풀이 공부해보기
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = my_string.split("");  //split 뭔지 찾기
        for(int i=arr.length-1; i>=0; i--){
            answer += arr[i];
        }
        return answer;
    }
}
