class Solution {
    public long solution(int a, int b) {        
        long answer = a+b;
        int n = a>b? a-b+1 : b-a+1;
        if(n%2==0){
            answer *= (n/2);
        }else{
            answer/=2;
            answer*=n;
        }
        return answer;
    }
}