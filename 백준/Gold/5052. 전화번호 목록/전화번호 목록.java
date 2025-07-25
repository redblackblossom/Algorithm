import java.util.*;
import java.io.*;

public class Main {
	
	static int root;
	static int unused;
	static int MX = 10000 * 10 +5;
	static boolean[] ch;
	static int[][] trie;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	
    	int t = sc.nextInt();
    	
    	for(int q =t; q>0;--q) {
    		String answer = "YES";
    		int n = sc.nextInt();
    		sc.nextLine();
    		
    		String[] arr = new String[n];
    		
    		for(int i =0; i<n;++i) {
    			arr[i] =  sc.nextLine();
    		}
    		root = 1;
    		unused = 2;
    		ch = new boolean[MX];
    		trie = new int[MX][10];
    		for(int i =0; i<MX;++i) {
    			for(int j =0; j<10;++j) {
    				trie[i][j] = -1;
    			}
    		}
    		
    		for(int i =0; i<n;++i) {
    			String nowString = arr[i];
    			//System.out.println(nowString);
    			int cur = root;  			
    			for(int j =0; j<nowString.length(); ++j) {
    				int nowChar = nowString.charAt(j) - '0';
    				if(trie[cur][nowChar] == -1) {
    					trie[cur][nowChar] = unused++;
    				}
    				cur = trie[cur][nowChar];
    				if(ch[cur] == true) {
    					answer = "NO";
    				}
    			}
    			ch[cur] = true;
    		}
    		
    		
    		for(int i =0; i<n;++i) {
    			String nowString = arr[i];
    			int cur = root;
    			for(int j = 0; j<nowString.length()-1; ++j) {
    				int nowChar = nowString.charAt(j) - '0';
    				cur = trie[cur][nowChar];
    				if(ch[cur] == true) {
    					answer = "NO";
    				}
    			}
    		}
    		
    		
    		System.out.println(answer);
    	}
    	
    }
}
