package Silver.S3.BOJ9461;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        list.add(1L);
        list.add(1L);
        list.add(2L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        list.add(7L);
        list.add(9L);
        while(true){
            list.add(list.get(list.size()-1) + list.get(list.size()-5));
            if(list.size() == 101){
                break;
            }
        }
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int num = Integer.parseInt(br.readLine());
            bw.write(list.get(num) + "\n");
        }
        bw.flush();
    }
}
