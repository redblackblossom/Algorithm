class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];
        
        if(money.length ==3 ){
            answer = Math.max(money[0],money[1]);
            answer = Math.max(answer,money[2]);
            
            return answer;
        }
        
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = dp[0] + money[2];
        
        for(int i =3; i<money.length -1;++i) {
            dp[i] = Math.max(dp[i-2], dp[i-3])  + money[i];
            
        }
        
        for(int i =0; i<money.length;++i){
            answer = Math.max(answer, dp[i]);
        }
        
        
        //다시 초기화
        for(int i =0; i<money.length;++i) {
            dp[i] =0;
        }
        
        dp[0] = 0;
        dp[1] = money[1];
        dp[2] = dp[0] + money[2];
        
        for(int i =3; i<money.length;++i) {
            dp[i] = Math.max(dp[i-2], dp[i-3])  + money[i];

        }
        
        for(int i =0; i<money.length;++i){
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}