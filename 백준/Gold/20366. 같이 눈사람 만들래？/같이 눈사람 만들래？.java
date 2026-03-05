import java.util.*;

public class Main {
    static int N;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for(int i=0; i<N;++i) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        for(int i =0; i<N;++i) {
            for(int j =i+1; j<N; ++j) {
                int a = i+1;
                int b = j-1;

                while(a < b) {
                    int accA = arr[i] + arr[j];
                    int accB = arr[a] + arr[b];
                    
                    ans = Math.min(ans, Math.abs(accA - accB));
                    if(accA < accB) {
                        b--;
                    } else if(accA > accB) {
                        a++;
                    } else {
                        break;
                    }
                }
                
            }
        }

        System.out.println(ans);
    }
}