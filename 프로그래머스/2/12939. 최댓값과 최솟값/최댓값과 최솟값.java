import java.util.*;
class Solution {
    public String solution(String s) {
        // str 공백 기준으로 끊어서 숫자 전환 -> 배열에 넣고 정렬하기 
        String[] words = s.split("\\s+");
        int[] numbers = new int[words.length];        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            numbers[i]=Integer.parseInt(word);
        }
        
        Arrays.sort(numbers);
        System.out.println(numbers[0]);
        
        String answer = numbers[0] + " "+ numbers[numbers.length-1];
        return answer;
    }
}