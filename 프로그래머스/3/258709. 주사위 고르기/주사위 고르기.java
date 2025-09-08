import java.util.*;

class Solution {
    static int n;
    static int[][] a_arr;
    static int[][] b_arr;
    static int[] answer; 
    static int max_cnt = 0;
    static int[] ch;
    static int[][] di;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        a_arr = new int[n/2][6];
        b_arr = new int[n/2][6];
        answer = new int[n/2];
        ch = new int[n];
        di = dice;
        
        recursive(n, n/2, 0);
        
        Arrays.sort(answer);
        return answer;
    }
    
    void recursive(int n, int r, int start) {
        if(r == 0){
            calc();
        } else {
            for(int i = start; i<n;++i){
                ch[i] = 1;
                recursive(n,r-1, i+1);
                ch[i] = 0;
            }
        }
    }
    
    void calc() {
        int a_idx = 0;
        int b_idx = 0;
        for(int i =0; i<n;++i){

            
            if(ch[i] == 0){
                a_arr[a_idx] = di[i];
                a_idx++;
            } else {
                b_arr[b_idx] = di[i];
                b_idx++;
            }
        }
        int max_len = (int)Math.pow(6,n/2);
        
        List<Integer> a_acc = new ArrayList<>();
        List<Integer> b_acc = new ArrayList<>();
        
        DFS(a_arr,0,0,a_acc);
        DFS(b_arr,0,0,b_acc);
        
        Collections.sort(a_acc);
        Collections.sort(b_acc);
        b_acc.add(Integer.MAX_VALUE/2);
        
        int start = 0;
        int tot = 0;
        for(int i =0; i<a_acc.size(); ++i){
            int now = a_acc.get(i);
            while(b_acc.get(start) < now){
                start++;
            }
            tot+= start;
        }
        
        if(max_cnt < tot){
            max_cnt = tot;
            int iidx = 0;
            for(int j =0; j<n; ++j){
                if(ch[j] ==0){
                    answer[iidx] = j+1;
                    iidx++;
                }
            }
        }
        
    }
    
    void DFS(int arr[][], int now, int acc, List<Integer> l){
        if(now == arr.length){
            l.add(acc);
        } else {
            for(int i =0; i<6;++i){
                DFS(arr, now+1, acc + arr[now][i], l);
            }
        }
    }
    
    
    
}