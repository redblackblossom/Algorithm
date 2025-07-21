import java.util.*;

public class Main {
	
	static int answer = 0;
	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        
         List<Character> listA = new ArrayList<>();
         List<Character> listB = new ArrayList<>();
        
         for(int i =0; i<a.length(); ++i) {
        	 listA.add(a.charAt(i));
         }
         
         for(int i =0; i<b.length(); ++i) {
        	 listB.add(b.charAt(i));
         }
         
         recuersive(listA,listB);
         System.out.println(answer);
         
    }
    
    static void recuersive(List<Character> A, List<Character> B) {
    	if(A.equals(B)) {
    		answer =1;
    		return;
    	} else if(A.size() > B.size() || B.size() ==0) {
    		return;
    	} else {
    		if (B.get(B.size() - 1).equals('A')) {
    	        List<Character> nextB = new ArrayList<>(B);
    	        nextB.remove(nextB.size() - 1);
    	        recuersive(A, nextB);
    	    }

    	    if (B.get(0).equals('B')) {
    	        List<Character> nextB = new ArrayList<>(B);
    	        nextB.remove(0);
    	        Collections.reverse(nextB);
    	        recuersive(A, nextB);
    	    }
    	}
    	
    	return;
    }
}
