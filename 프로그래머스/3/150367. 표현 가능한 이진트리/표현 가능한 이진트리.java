import java.util.*;

class Solution {
    static int ans = 1;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
       for(int i =0; i<numbers.length; ++i){
           ans = 1;
           List<Integer> bin = toBinary(numbers[i]);
           //System.out.println(bin);
           recursive(bin, 0, bin.size()-1, 0);
           answer[i] = ans;
       }
        return answer;
    }
    
    void recursive(List<Integer> list, int start, int end, int ch) {
        if(start == end){
            if(list.get(start) == 0 && ch== 1){
                ans = 1;
                return;
            } else {
                return;
            }
        } 
        else {
            //System.out.println(start + " " + end);
            if(ans == 0){
                return;
            }
            int cch = ch;
            int mid = (start + end) /2;
            if(list.get(mid) == 0){
                cch = 1;
                if(list.get(mid-1)==1 || list.get(mid+1)==1) {
                    ans = 0;
                    return;
                }
            }
            if(cch == 1 && list.get(mid)==1){
                ans = 0;
                return;
            }
            recursive(list, start, mid-1, cch);
            recursive(list, mid + 1, end, cch);

        }
    }
    
    List<Integer> toBinary(long num){
        List<Integer> binary = new ArrayList<>();
        while(num !=0){
            if(num%2 == 0) {
                binary.add(0);
            } else {
                binary.add(1);
            }
            num = num/2;
        }
        
        while(true){
            if(Integer.bitCount(binary.size() + 1) ==1){
                break;
            } else {
                binary.add(0);
            }
        }
        
         Collections.reverse(binary);
        
        return binary;
    }
}