package Silver.S3.BOJ9095;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    static int number;
    static int count;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            number = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            count = 0;
            combination(0, 0);
            bw.write(count + "\n");
        }
        bw.flush();
    }

    public static void combination(int sum, int depth){
        if(sum == number){
            count++;
            return;
        }
        if(sum > number){
            return;
        }
        list.add(1);
        combination(sum+1, depth+1);
        list.remove(list.size()-1);

        list.add(2);
        combination(sum+2, depth+1);
        list.remove(list.size()-1);

        list.add(3);
        combination(sum+3, depth+1);
        list.remove(list.size()-1);
    }
}
