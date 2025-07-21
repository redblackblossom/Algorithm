import java.util.*;

public class Main {
	
	static int[] node;
	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextInt();
        }
        
        node = new int[4 * n];
        
        
        
        init(arr, 1, 0,n-1);
        
        
        int T = sc.nextInt();
        
        for(int i =0; i<T; ++i) {
        	int a,b,c;
        	a = sc.nextInt();
        	b= sc.nextInt();
        	c = sc.nextInt();
        	
        	if(a==1) {
        		b--;
        		update(1, c,b, 0, n-1);
        		
        	} else {
        		b--;
        		c--;
        		
        		System.out.println(query(1,b,c,0,n-1));
        	}
   
        }
        
        
        
    }
    
    static int init(int[] arr, int nowNode, int leftIndex, int rightIndex) {
    	if(leftIndex == rightIndex) {
    		return node[nowNode] = arr[leftIndex];
    	}
    	
    	int mid = (leftIndex + rightIndex) / 2;
    	int leftValue = init(arr, nowNode *2, leftIndex, mid);
    	int rightValue = init(arr, nowNode*2 +1, mid+1, rightIndex);
    	
    	
    	if(leftValue > rightValue) {
    		return node[nowNode] = rightValue;
    	} else {
    		return node[nowNode] = leftValue;
    	}
    }
    
    static int query(int nowNode, int leftQuery, int rightQuery, int leftIndex, int rightIndex) {
    	if (leftQuery <= leftIndex && rightIndex <= rightQuery) {
            return node[nowNode];
        }
    	
    	if (rightIndex < leftQuery || rightQuery < leftIndex) {
            return Integer.MAX_VALUE; 
        }
    	
    	int mid = (leftIndex + rightIndex) / 2;
    	int leftValue = query(nowNode*2, leftQuery, rightQuery, leftIndex, mid);
    	int rightValue = query(nowNode*2 +1 , leftQuery, rightQuery,  mid +1, rightIndex);
    	
    	
    	return Math.min(leftValue, rightValue);
    }
    
    static int update(int nowNode, int newValue,int newIndex, int leftIndex, int rightIndex) {
    	if(newIndex < leftIndex || rightIndex < newIndex) {
    		return node[nowNode];
    	}
    	
    	if(leftIndex == rightIndex) {
    		return node[nowNode] = newValue;
    	}
    	

    	
    	int mid = (leftIndex + rightIndex) / 2;
    	int leftValue = update(nowNode * 2, newValue, newIndex, leftIndex, mid);
    	int rightValue = update(nowNode * 2+1, newValue, newIndex, mid +1 , rightIndex);
    	
    	return node[nowNode] = Math.min(rightValue, leftValue);
    }
}
