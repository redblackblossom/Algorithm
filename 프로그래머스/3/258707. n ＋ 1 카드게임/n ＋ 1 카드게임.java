import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        int[] hand = new int[n+1];
        int[] tmp = new int[n+1];
        
        Deque<Integer> card = new ArrayDeque<>();
        
        for(int i =0; i<n;++i){
            card.addLast(cards[i]);
        }
        
        for(int i =0; i<n/3;++i){
            hand[card.pollFirst()] = 1;
            //System.out.println(card.pollFirst());
        }
        
        for(int i =1; i<=n;++i){
            //System.out.println(hand[i]);
            
        }
        
        while(true) {
               int ch =0;
            for(int i =0; i<2;++i){
                if(card.isEmpty()) {
                    ch =1;
                    break;
                }
                tmp[card.pollFirst()] = 1;
            }
            if(ch==1){
                break;
            }
            
         
            
            for(int i =1; i<=n/2;++i){
                if(hand[i] ==1 && hand[n+1 -i]==1){
                    hand[i] = 0;
                    hand[n+1 -i] = 0;
                    System.out.println("hand :" + i);
                    int asd = n+1 -i;
                    System.out.println("hand :" + asd);
                    ch =1;
                    break;
                }
            }
            if(ch==1){
                answer++;
                continue;
            }
            
            if(coin >=1){
                for(int i =1; i<=n;++i){
                    if(hand[i] ==1 && tmp[n+1 -i]==1){
                        hand[i] = 0;
                        tmp[n+1 -i] = 0;
                        ch =1;
                        coin--;
                        System.out.println("hand :" + i);
                        int asd = n+1 -i;
                        System.out.println("tmp :" + asd);
                        break;
                    }
                }
            }
            if(ch==1){
                answer++;
                continue;
            }
            
            if(coin >=2) {
                for(int i =1; i<=n/2;++i){
                    if(tmp[i] ==1 && tmp[n+1 -i]==1){
                        tmp[i] = 0;
                        tmp[n+1 -i] = 0;
                        ch =1;
                        coin-=2;
                        
                        System.out.println("tmp :" + i);
                        int asd = n+1 -i;
                        System.out.println("tmp :" + asd);
                        break;
                    }
                }
            }
            if(ch==1){
                answer++;
                continue;
            }
            
            break;
            
        }
        
        return answer;
    }
}