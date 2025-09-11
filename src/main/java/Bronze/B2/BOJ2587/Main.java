package Bronze.B2.BOJ2587;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<5; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        sum += pq.poll();
        sum += pq.poll();
        int center = pq.peek();
        sum += pq.poll();
        sum += pq.poll();
        sum += pq.poll();
        bw.write((sum/5) + "\n");
        bw.write(center + "\n");
        bw.flush();
    }
}
