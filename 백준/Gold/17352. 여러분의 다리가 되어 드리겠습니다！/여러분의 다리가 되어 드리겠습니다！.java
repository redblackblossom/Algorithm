//package samsung01;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] parent;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	parent = new int[n];
    	
    	for(int i =0; i<n;++i) {
    		parent[i] = i;
    	}
		 
    	for(int i =0; i<n-2;++i) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		a--;
    		b--;
    		
    		union(a,b);
    	}
    	
    	int first = find(0);
    	int second = 0;
    	for(int i =1; i<n;++i) {
    		if(first!= find(i)) {
    			second = find(i);
    			break;
    		}
    	}
    	first++;
    	second++;
    	System.out.println(first + " " + second);
		
    }
    
    static int find(int v) {
    	if(parent[v] == v) {
    		return v;
    	} else {
    		return parent[v] = find(parent[v]);
    	}
    }
    
    static void union(int a, int b) {
    	int parentA = find(a);
    	int parentB = find(b);
    	
    	if(parentA != parentB) {
    		parent[parentA] = parentB;
    	}
    }
   
}
