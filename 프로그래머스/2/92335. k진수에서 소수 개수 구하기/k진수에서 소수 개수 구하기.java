class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n,k);
        
        System.out.println(s);
        
        String[] nums = s.split("0+");
        
        for(int i=0; i<nums.length; ++i){
            if(isPrime(nums[i])){
                answer ++;
            }
        }
        
        return answer; 
    }
    
    boolean isPrime(String s) {
        long num = Long.parseLong(s);
        if(num==1)return false;
        
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}