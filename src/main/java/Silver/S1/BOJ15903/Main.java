package Silver.S1.BOJ15903;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }
        for(int i=0; i<m; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;
            pq.offer(sum);
            pq.offer(sum);
        }
        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
