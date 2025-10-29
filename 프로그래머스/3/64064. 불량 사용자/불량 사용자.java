import java.util.*;

class Solution {
    
    int ans = 0;
    String[] userId;
    String[] bannedId;
    int[] ch;
    Map<Integer, Integer> m = new HashMap<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        userId = user_id;
        bannedId = banned_id;
        ch = new int[user_id.length];
        
        recursive(0,user_id.length, banned_id.length);
        
        return answer = ans;
    }
    
    public void recursive(int depth, int n, int r) {
        if(r == depth){
            int idx = 0;
            for(int i =0; i<ch.length;++i){
                int tmp = 1;
                if(ch[i] == 1){
                    tmp = (1<< i);
                    idx += tmp;
                    tmp = 1;
                }
            }
            if(!m.containsKey(idx)){
                ans++;
                m.put(idx, 1);
            }
            
            
        } else {
            for(int i =0; i<n;++i){
                if(check(userId[i], bannedId[depth]) && ch[i] ==0){
                    ch[i] =1;
                    recursive(depth+1, n, r);
                    ch[i] = 0;
                }
                
            }
        }
    }
    
    boolean check(String name, String ban) {
        if(name.length() != ban.length()){
            return false;
        }
        
        for(int i =0; i<ban.length(); ++i){
            if(ban.charAt(i) == '*'){
                continue;
            } else if(ban.charAt(i) != name.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}