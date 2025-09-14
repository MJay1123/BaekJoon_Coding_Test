package Bronze.B1.BOJ10989;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            list.add(pq);
        }
        int[] array = new int[10001];
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            array[num]++;
        }
        int count = 0;
        for(int i=1; i<=10000; i++){
            for(int j=0; j<array[i]; j++){
                bw.write(i + "\n");
                count++;
            }
            if(count == N){
                break;
            }
        }
        bw.flush();
    }
}
