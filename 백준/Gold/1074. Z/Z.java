import java.util.*;
import java.io.*;

public class Main {
	
	static long ans = 0;
	static int x;
	static int y;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	x = sc.nextInt();
    	y = sc.nextInt();
    	
    	long nn =(long) Math.pow(2,n) *(long) Math.pow(2,n);
    	int start = 0;
    	int end = (int) Math.pow(2,n);
    	
    	recursive(0,end,0,end,start, nn);
    	System.out.println(ans);
    }
    
    static void recursive(int startX, int endX, int startY, int endY, long underBound, long upperBound) {
    	if(startX <= x && endX >x && startY <= y && endY >y) {
    		if(endX - startX ==1) {
    			if(startX == x && startY == y) {
    				ans = underBound;
    			} else if (startX == x && startY+1 == y) {
    				ans = underBound + 1;
    			}else if (startX +1 == x && startY == y) {
    				ans = underBound + 2;
    			} else {
    				ans = underBound + 3;
    			}
    			
    		} else {
    			int midX = (startX + endX) / 2;
    			int midY = (startY + endY) / 2;
    			long dx = (upperBound - underBound) / 4;
    			
    			recursive(startX, midX, startY, midY, underBound, underBound + dx);
    			recursive(startX, midX, midY, endY, underBound + dx, underBound + 2* dx);
    			recursive(midX, endX, startY, midY, underBound + 2* dx, underBound + 3* dx);
    			recursive(midX, endX, midY, endY, underBound + 3* dx, upperBound);
    		}
    	} else {
    		return;
    	}
    }
    
    
}
