import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> m = new HashMap<>();
        Map<String, Integer> to = new HashMap<>();
        int[][] ch = new int[1000][1000];
        
        for(int i =0; i<id_list.length; ++i){
            m.put(id_list[i], 0);
            to.put(id_list[i], i);
        }
        
        for(int i =0; i<report.length; ++i){
            String[] r = report[i].split(" ");
            
            int a = to.get(r[0]);
            int b = to.get(r[1]);
            if(ch[a][b] ==0){
                ch[a][b] =1;
                            
                int num = m.get(r[1]);

                m.put(r[1], num+1);
            }
            
            

        }
        
        ch = new int[1000][1000];
        for(int i =0; i<report.length; ++i){
            String[] r = report[i].split(" ");
            

            
            int a = to.get(r[0]);
            int b = to.get(r[1]);
            
            int num = m.get(r[1]);
            
            if(num >= k && ch[a][b] ==0){
                ch[a][b] =1;
                int nn = to.get(r[0]);
                answer[nn]++;
            }

        }
        
        
        
        return answer;
    }
}