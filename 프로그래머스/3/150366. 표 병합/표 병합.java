import java.util.*;

class Solution {
    
    String[] arr;
    int[] parent;
    
    public String[] solution(String[] commands) {
        String[] answer = {};
        arr = new String[2500];
        parent = new int[2500];
        
        for(int i=0; i<arr.length;++i){
            arr[i] = "EMPTY";
            parent[i] = i;
        }
        
        List<String> ans = new ArrayList<>();
        for(int q =0; q<commands.length; ++q){
            String[] c = commands[q].split(" ");
            String op = c[0];
            
            if(op.equals("UPDATE") && c.length == 4) {
                List<Integer> l = new ArrayList<>();
                int rr = Integer.parseInt(c[1]) ;
                int cc = Integer.parseInt(c[2]);
                rr--;
                cc--;
                int f = find(toVec(rr,cc));
                for(int i =0; i<50;++i){
                    for(int j =0; j<50;++j){
                        int tmp = find(toVec(i,j));
                        if(tmp == f){
                            l.add(toVec(i,j));
                        }
                    }
                }
                for(int i =0;i<l.size(); ++i){
                    arr[l.get(i)] = c[3];
                }
                
                
            } else if(op.equals("UPDATE")){
                String value1 =c[1];
                String value2 =c[2];
                
                for(int i =0; i<arr.length; ++i){
                    if(arr[i].equals(value1)){
                        arr[i] = value2;
                    }
                }
                
                
            } else if(op.equals("MERGE")) {
                int r1 = Integer.parseInt(c[1]);
                int c1 = Integer.parseInt(c[2]);
                int r2 = Integer.parseInt(c[3]);
                int c2 = Integer.parseInt(c[4]);
                
                r1--;c1--;r2--;c2--;
                
                int v1 = toVec(r1,c1);
                int v2 = toVec(r2,c2);
                
                if(arr[v1].equals("EMPTY") && !arr[v2].equals("EMPTY")) {
                    //v1에 있는 데이터를 모두 v2로 바꿔야됨
                    
                    List<Integer> l = new ArrayList<>();
                    int p1 = find(v1);
                    for(int i =0; i<parent.length;++i){
                        if(p1 == find(i)){
                            l.add(i);
                        }
                    }
                    
                    for(int i =0; i<l.size(); ++i){
                        arr[l.get(i)] = arr[v2];
                    }
                } else if(!arr[v1].equals("EMPTY") && arr[v2].equals("EMPTY")) {
                    //v2에 있는 데이터를 모두 v1로 바꿔야됨
                    
                    List<Integer> l = new ArrayList<>();
                    int p2 = find(v2);
                    for(int i =0; i<parent.length;++i){
                        if(p2 == find(i)){
                            l.add(i);
                        }
                    }
                    
                    for(int i =0; i<l.size(); ++i){
                        arr[l.get(i)] = arr[v1];
                    }
                } else if(!arr[v1].equals("EMPTY") && !arr[v2].equals("EMPTY")) {
                    List<Integer> l = new ArrayList<>();
                    int p2 = find(v2);
                    for(int i =0; i<parent.length;++i){
                        if(p2 == find(i)){
                            l.add(i);
                        }
                    }
                    
                    for(int i =0; i<l.size(); ++i){
                        arr[l.get(i)] = arr[v1];
                    }
                }
                
                v1 = find(v1);
                v2 = find(v2);
                union(v1,v2);
                
            } else if(op.equals("UNMERGE")) {
                int rr = Integer.parseInt(c[1]);
                int cc = Integer.parseInt(c[2]);
                rr--;cc--;
                
                int v = toVec(rr,cc);
                int root = find(v);
                String ss = arr[v];
                
                List<Integer> l = new ArrayList<>();
                
                for(int i =0; i<arr.length;++i){
                    if(root == parent[i]){
                        l.add(i);
                    }
                }
                
                for(int i =0; i<l.size();++i){
                    int qq = l.get(i);
                    parent[qq] = qq;
                    arr[qq] = "EMPTY";
                }
                
                arr[v] = ss;
                
            } else {
                int rr = Integer.parseInt(c[1]);
                int cc = Integer.parseInt(c[2]);
                rr--;cc--;
                ans.add(arr[toVec(rr,cc)]);
            }
            
        }
        
        answer = new String[ans.size()];
        for(int i =0; i<ans.size(); ++i){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    int toVec(int r, int c){
        return 50 * r + c;
    }
    
    int find(int a){
        if(a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
    
    int union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b){
            return a;
        }
        return parent[a] = b;
    }
    
}