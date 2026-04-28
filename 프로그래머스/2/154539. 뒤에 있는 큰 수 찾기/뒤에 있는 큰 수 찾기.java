import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        //뒤에서부터 가면서  
        // 내 뒤에 있는 애가 나보다 작다면 걔보다 큰 애가 나보다 큰지 보기 
        int i = numbers.length-2;
        while(i>=0){
            int findI = i+1;
            while(findI!=-1 && numbers[i] >= numbers[findI]){
                findI = answer[findI];
            }
            answer[i] = findI;
            i--;
        }
        for(int j=0;j<numbers.length;j++){
            if(answer[j]!=-1){
                answer[j]=numbers[answer[j]];
            }
        }
        return answer;
    }
}