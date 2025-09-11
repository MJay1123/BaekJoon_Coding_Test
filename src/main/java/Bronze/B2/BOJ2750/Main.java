package Bronze.B2.BOJ2750;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<N; i++){
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
    }
}
