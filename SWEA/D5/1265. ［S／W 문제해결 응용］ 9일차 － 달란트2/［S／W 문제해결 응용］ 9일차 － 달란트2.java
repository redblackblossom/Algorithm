import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int div = sc.nextInt();
            long a = n /div;
            long b = n %div;
            long sol = 1;
            for(int i =0; i<div - b;++i){
                sol = sol * a;
            }
            for(int i=0; i<b;++i){
                sol = sol * (a+1);
            }
                
            System.out.println("#" + test_case+ " " + sol);
		}
	}
}