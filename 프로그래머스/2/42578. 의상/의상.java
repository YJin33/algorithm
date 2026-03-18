import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,List<String>>map = new LinkedHashMap<>();
        int answer = 1;
        for(String[] s : clothes){//옷의 종류에 따라 해시맵에 리스트로 저장
            List<String>list = map.get(s[1])!=null ? map.get(s[1]) :  new ArrayList<String>();
            list.add(s[0]);
            map.put(s[1], list);
        }
        for(String s : map.keySet()){
            answer *=(map.get(s).size()+1); //경우의 수 계산 
        }

        return answer-1; //아무것도 선택 안하는 경우 제외
    }
}