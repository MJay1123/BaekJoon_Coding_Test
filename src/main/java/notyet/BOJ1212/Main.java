package notyet.BOJ1212;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
//        if(!(str.charAt(str.length()-1) > '0' && str.charAt(str.length()-1) < '9')){
//            str = str.substring(0, str.length()-1);
//        }
        N = Long.parseLong(str);

        List<Long> list = new ArrayList<>();
        while(N > 0){
            long digit = N % 10;
            for(int i=0; i<3; i++){
                list.add(digit % 2);
                digit /= 2;
            }
            N /= 10;
        }
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i) == 1){
                break;
            } else {
                list.remove(i);
            }
        }
        for(int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i));
        }
    }
}
