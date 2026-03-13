import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations); // 오름차순 정렬

        int index = 0;
        int hIndex = citations.length; //최대 논문수 : 1000개 -> h-index의 최댓값은 1000        
            
        while(index<=hIndex){
            if(citations[index]>=hIndex){
                return hIndex;
            }
            index++;
            hIndex--;
        }
        
        
        int answer = 0;
        return answer;
    }
}