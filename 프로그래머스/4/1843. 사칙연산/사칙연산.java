class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int[] num = new int[arr.length/2 +1];
        String[] op = new String[arr.length/2];
        
        for(int i =0; i<arr.length;++i){
            if(i%2 ==0){
                num[i/2] = Integer.valueOf(arr[i]);
            } else {
                op[i/2] = arr[i];
            }
        }
        
        //0 : 최솟값, 1 : 최댓값 
        int[][][] dp = new int[num.length][num.length][2];
        
        for(int i=0; i<num.length;++i){
            for(int j =0; j<num.length;++j){
                dp[i][j][0] = Integer.MAX_VALUE/10;
                dp[i][j][1] = Integer.MIN_VALUE/10;
            }
        }
        
        for(int i =0; i<num.length;++i){
            dp[i][i][0] = num[i];
            dp[i][i][1] = num[i];
        }
        
        for(int i =0; i<num.length-1;++i){
            dp[i][i+1][0] = calc(num[i], num[i+1], op[i]);
            dp[i][i+1][1] = calc(num[i], num[i+1], op[i]);
        }
        
        for (int len = 3; len <= num.length; ++len) {
            for (int start = 0; start + len - 1 < num.length; ++start) {
                int end = start + len - 1;
                for (int k = start; k < end; ++k) { 
                    if (op[k].equals("-")) {
                        dp[start][end][0] = Math.min(dp[start][end][0],dp[start][k][0] - dp[k + 1][end][1]);
                        dp[start][end][1] = Math.max(dp[start][end][1],dp[start][k][1] - dp[k + 1][end][0]);
                    } else {
                        dp[start][end][0] = Math.min(dp[start][end][0],dp[start][k][0] + dp[k + 1][end][0]);
                        dp[start][end][1] = Math.max(dp[start][end][1],dp[start][k][1] + dp[k + 1][end][1]);
                    }
                }
            }
        }
        
        answer = dp[0][num.length-1][1];
        
        return answer;
    }
    
    static int calc (int a, int b, String op){
        if(op.equals("-")){
            return a - b;
        } else {
            return a+b;
        }
    }
}