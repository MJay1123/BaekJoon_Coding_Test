package Silver.S4.BOJ2217;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<ropes.length; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int max = 0;
        int count = 1;
        while(!pq.isEmpty()){
            max = Math.max(max, pq.poll() * count++);
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
