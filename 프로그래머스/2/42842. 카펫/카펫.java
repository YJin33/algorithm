class Solution {
    public int[] solution(int brown, int yellow) {
        //yellow: a*b 
        //brown: (a+2)*(b+2) - ab = 2(a+b)+4        
        //yellow 의 약수 조합을 찾아서 brown + yellow = (a+2)*(b+2)인지 확인
        
        int i=1;
        int[] answer = new int[2];
        while(i*i<=yellow){
            int w = yellow/i;
            if(yellow%i==0 && (i+2)*(w+2) == yellow + brown){
                answer[0]=w+2;
                answer[1]=i+2;
            }
            i++;
        }
        
        return answer;
    }
}