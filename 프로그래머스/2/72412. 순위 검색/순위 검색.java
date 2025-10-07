import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] langs = {"cpp","java", "python", "-"};
        String[] devs = {"backend", "frontend", "-"};
        String[] years = {"junior", "senior", "-"};
        String[] foods = {"chicken", "pizza", "-"};
        
        
        Map<String, List<Integer>> m = new HashMap<>();
        for(int a = 0; a<4;++a){
            for(int b = 0; b<3;++b){
                for(int c = 0; c<3;++c){
                    for(int d = 0; d<3;++d){
                        String s = langs[a] + devs[b] + years[c] + foods[d];
                        List<Integer> l = new ArrayList<>();
                        m.put(s, l);
                        
                    }
                }
            }
        }
        
        for(int i =0; i<info.length; ++i){
            String[] s = info[i].split(" ");
            String lang = s[0];
            String dev = s[1];
            String year = s[2];
            String food = s[3];
            
            int score = Integer.parseInt(s[4]);
            
            String tmp = lang + dev + year + food;
            m.get(tmp).add(score);
            
            tmp = "-" + dev + year + food;
            m.get(tmp).add(score);
            
            tmp = lang + "-" + year + food;
            m.get(tmp).add(score);
            
            tmp = lang + dev + "-" + food;
            m.get(tmp).add(score);
            
            tmp = lang + dev + year + "-";
            m.get(tmp).add(score);
            
            //2
            tmp = "-" + "-" + year + food;
            m.get(tmp).add(score);
            
            tmp = lang + "-" + "-" + food;
            m.get(tmp).add(score);
            
            tmp = lang + dev + "-" + "-";
            m.get(tmp).add(score);
            
            
            tmp = "-" + dev + "-" + food;
            m.get(tmp).add(score);
            
            tmp = "-" + dev + year + "-";
            m.get(tmp).add(score);
            
            tmp = lang + "-" + year + "-";
            m.get(tmp).add(score);
            
            
            tmp = lang + "-" + "-" + "-";
            m.get(tmp).add(score);
            
            tmp = "-" + dev + "-" + "-";
            m.get(tmp).add(score);
            
            tmp = "-" + "-" + year + "-";
            m.get(tmp).add(score);
            
            tmp = "-" + "-" + "-" + food;
            m.get(tmp).add(score);
            
            tmp = "-" + "-" + "-" + "-";
            m.get(tmp).add(score);
        }
        
        
        for(String key : m.keySet()){
            Collections.sort(m.get(key));
        }
        
        for(int i =0; i<query.length; ++i){
            String[] s = query[i].split(" ");
            String lang = s[0];
            String dev = s[2];
            String year = s[4];
            String food = s[6];
            int score = Integer.parseInt(s[7]);
            
            
            answer[i] = binary(m.get(lang + dev + year + food), score);
            
        }
        
        //System.out.println(binary(new ArrayList<>(List.of(1,2,4,5)), 1));
        
        return answer;
    }
    
    int binary(List<Integer> list, int target){
        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = (start + end) / 2;
            if (list.get(mid) < target) start = mid + 1;
            else end = mid;
        }

        return list.size() - end;
    }

    
}