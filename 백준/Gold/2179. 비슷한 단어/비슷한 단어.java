import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextLine();
        }

        Map<String, List<Integer>> map = new HashMap<>();

        for(int i =0; i<n;++i){
            for(int j=0; j<arr[i].length(); ++j){
                String tmp = arr[i].substring(0, j+1);

                if(!map.containsKey(tmp)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(tmp, list);
                } else {
                    map.get(tmp).add(i);
                }
            }
        }

        int maxLen = -1;
        int firstIdx = -1;
        int secondIdx = -1;

        for (String key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() >= 2) {
                int len = key.length();
                int a = list.get(0);
                int b = list.get(1);

                if (len > maxLen) {
                    maxLen = len;
                    firstIdx = a;
                    secondIdx = b;
                }

                else if (len == maxLen) {
                    if (a < firstIdx) {
                        firstIdx = a;
                        secondIdx = b;
                    } else if (a == firstIdx && b < secondIdx) {
                        firstIdx = a;
                        secondIdx = b;
                    }
                }
            }
        }

        if (firstIdx == -1) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[firstIdx]);
            System.out.println(arr[secondIdx]);
        }

    }

}