package Silver.S4.BOJ1337;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 올바른 배열
public class Main {
    static int N;
    static List<Long> list;
    static int max = 1;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<Long>();
        for(int i=0; i<N; i++){
            long num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        list.add(-1L);
        list.add(-1L);
        list.add(-1L);
        list.add(-1L);
        Collections.sort(list);
        for(int i=0; i<N-4; i++){
            count = 1;
            for(int j=1; j<=4; j++){
                if(list.get(i+j) - list.get(i) <= 4 && list.get(i+j) > 0){
                    count++;
                    System.out.println(list.get(i+j));
                    System.out.println(list.get(i));
                    System.out.println("count = " + count);
                }
                max = Math.max(max, count);
            }
        }
//        System.out.println("max = " + max);
        bw.write(5 - max + "\n");
        bw.flush();
    }
}
