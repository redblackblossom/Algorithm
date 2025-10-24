import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 100000000;
        int alp_req =0;
        int cop_req =0;
        
        for(int i=0; i<problems.length;++i){
            alp_req = Math.max(alp_req, problems[i][0]);
            cop_req = Math.max(cop_req, problems[i][1]);
        }
        
        int[][] dp = new int[alp_req +10][cop_req + 10];
        
        for(int i =0; i< alp_req +9; i++){
            for(int j = 0; j<cop_req + 9; ++j) {
                dp[i][j] = 100000000;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        pq.add(new Node(alp, cop, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int alg = now.alg;
            int cod = now.cod;
            int time = now.time;
            
            if(dp[alg][cod] < time){
                continue;
            }
            
            int tmp = alg + 1;
            if (tmp > alp_req) {
                tmp = alp_req;
            }
            if (dp[tmp][cod] > time + 1) {
                dp[tmp][cod] = time + 1;
                pq.add(new Node(tmp, cod, time + 1));
            }

            tmp = cod + 1;
            if (tmp > cop_req) {
                tmp = cop_req;
            }
            if (dp[alg][tmp] > time + 1) {
                dp[alg][tmp] = time + 1;
                pq.add(new Node(alg, tmp, time + 1));
            }
            
            for(int i =0; i<problems.length; ++i){
                int nalg = problems[i][0];
                int ncod = problems[i][1];
                int ntime = problems[i][4];
                
                if(alg >= nalg && cod >= ncod){
                    int nnalg = alg + problems[i][2];
                    int nncod = cod + problems[i][3];
                    if(nnalg > alp_req) {
                        nnalg = alp_req;
                    }
                    if(nncod >cop_req) {
                        nncod = cop_req;
                    }
                    
                    if(dp[nnalg][nncod] > time + ntime ) {
                        dp[nnalg][nncod] = time + ntime;
                        pq.add(new Node(nnalg,nncod,  time + ntime));
                    }
                }
            }
            
        }
        
        answer = dp[alp_req][cop_req];
        for(int i =alp_req; i<alp_req +10; ++i){
            for(int j =cop_req; j<cop_req+10; ++j){
                answer = Math.min(dp[alp_req][cop_req],answer);
            }
        }
        
        return answer;
    }
    
    class Node {
        int alg;
        int cod;
        int time;
        
        Node (int a, int b, int c){
            alg = a;
            cod = b;
            time = c;
        }
    }
}