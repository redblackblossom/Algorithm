import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int zeroCount = 0;
        int oneCount = 0;
        List<Integer> list = new ArrayList<>();

        for(int i =0; i<s.length();++i){
            if(s.charAt(i)=='0'){
                zeroCount++;
                list.add(0);
            } else if(s.charAt(i)=='1'){
                oneCount++;
                list.add(1);
            }
        }
        zeroCount = zeroCount/2;
        oneCount = oneCount/2;

        //1은 앞에서 부터 지우고, 0은 뒤에서 부터 지운다.

        for(int i =list.size() -1; i>= 0;--i){
            if(list.get(i)==0 && zeroCount >0){
                list.set(i, -1);
                zeroCount--;
            }
        }
        for(int i =0; i<list.size();++i){
            if(list.get(i)==1 && oneCount >0){
                list.set(i, -1);
                oneCount--;
            }
        }
/*
        for(int i =0; i<list.size();++i){
            System.out.print(list.get(i)+" ");
        }
*/

        for(int i =0; i<list.size();++i){
            if(list.get(i) == -1){
                continue;
            } else {
                System.out.print(list.get(i));
            }
        }
    }
}