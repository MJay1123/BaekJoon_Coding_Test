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
        Collections.sort(list);
        list.add(0L);
        list.add(0L);
        list.add(0L);
        list.add(0L);
//        System.out.println(list);
        for(int i=0; i<N; i++){
            count = 1;
            for(int j=1; j<=4; j++){
                if(list.get(i+j) - list.get(i) <= 4 && list.get(i+j) > 0){
                    count++;
                }
                max = Math.max(max, count);
            }
//            System.out.println("count = " + count);
        }
//        System.out.println("max = " + max);
        bw.write(5 - max + "\n");
        bw.flush();
    }
}
