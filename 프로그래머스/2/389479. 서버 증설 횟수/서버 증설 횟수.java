class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] maximum = new int[100];
        int now = m-1;
        for(int i=0; i<players.length;++i){
            now -= maximum[i] * m;
            
            
            if(now < players[i]){
                int cnt = (players[i] - now) / m;
                if((players[i] - now) % m != 0 ){
                    cnt++;
                }
                
                now += cnt * m;
                answer += cnt;
                maximum[i] = cnt;
                maximum[i + k] = cnt;
            }
            System.out.println(i + " " + now);
        }
        for(int i=0; i<players.length;++i){
            //System.out.println(maximum[i]);
        }
        return answer;
    }
}