import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        Map<String,Integer> t = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        
        
        for(int i =0; i<terms.length; ++i){
            String[] s = terms[i].split(" ");
            t.put(s[0], Integer.parseInt(s[1]) * 28);
        }
        int now = toInt(today);
        
        for(int i =0; i<privacies.length; ++i){
            int expired = toInt(privacies[i]);
            int mid = t.get(privacies[i].substring(11));
            if(expired + mid-1 < now) {
                li.add(i+1);
            }
        }
        answer = new int[li.size()];
        for(int i =0; i<answer.length; ++i){
            answer[i] = li.get(i);
        }
        
        return answer;
    }
    
    int toInt(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        year = year * 12 * 28;
        month = month *28;
        return year + month + day;
    }
}