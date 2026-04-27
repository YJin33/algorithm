class Solution {
    public int solution(int[] number) {
        // int answer = 0;
        //3 더해서 0 만들기 경우의 수 
        //백트래킹 아닌가?
        int answer = dfs(number, 0, 0, 0);
        return answer;
    }

    public int dfs(int[]number, int i, int depth, int sum ){
        int cnt=0;
        if(depth==3){
            if(sum==0){
                cnt++;
                return cnt;
            }
            return 0;
        }
        else if(i>=number.length){
            return 0;
        }
        cnt+=dfs(number, i+1, depth+1, sum+number[i]);
        cnt+=dfs(number, i+1, depth, sum);
        return cnt;
    }
}