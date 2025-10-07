import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('R', 0);
        m.put('T', 0);
        m.put('C', 0);
        m.put('F', 0);
        m.put('J', 0);
        m.put('M', 0);
        m.put('A', 0);
        m.put('N', 0);
        
        for(int i =0; i<survey.length; ++i){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int val = choices[i];
            if(val ==1){
                int now = m.get(a);
                now += 3;
                m.put(a, now);
                
            } else if(val == 2) {
                int now = m.get(a);
                now += 2;
                m.put(a, now);
            }else if(val == 3) {
                int now = m.get(a);
                now += 1;
                m.put(a, now);
            } else if(val == 5) {
                int now = m.get(b);
                now += 1;
                m.put(b, now);
            }else if(val == 6) {
                int now = m.get(b);
                now += 2;
                m.put(b, now);
            } else if(val == 7) {
                int now = m.get(b);
                now += 3;
                m.put(b, now);
            }
        }
        
        if(m.get('R') >= m.get('T')) {
            answer += "R";
        } else {
            answer += "T";
        }
        
        if(m.get('C') >= m.get('F')) {
            answer += "C";
        } else {
            answer += "F";
        }
        
        if(m.get('J') >= m.get('M')) {
            answer += "J";
        } else {
            answer += "M";
        }
        
        if(m.get('A') >= m.get('N')) {
            answer += "A";
        } else {
            answer += "N";
        }
        
        return answer;
    }
}