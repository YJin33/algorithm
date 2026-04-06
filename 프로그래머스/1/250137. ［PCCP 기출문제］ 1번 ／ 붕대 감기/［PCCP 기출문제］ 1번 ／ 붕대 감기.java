class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t = bandage[0]; //추가 보상 주는 시간
        int x = bandage[1]; //초당 체력 + 
        int y = bandage[2]; //추가 체력
        int hp = health; //현재 체력 = 최대 체력
        int last = 0; //직전 공격
        
        for(int[] attack : attacks){
            int now = attack[0]; //공격 시점
            int damage = attack[1]; //데미지 
            
            //그동안의 체력 더하기 
            hp += x*(now-last-1);
            hp += (int)((now-last-1)/t) *y;
            
            hp = hp>health? health : hp; //최대 체력 적용
            
            //데미지 넣기 
            hp -= damage;
            if(hp<=0){
                return -1;
            }
            last = now; //다음 스텝으로
        }
        
        
        
        return hp;
    }
}