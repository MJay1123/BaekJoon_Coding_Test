package Silver.S3.BOJ13305;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] street = new long[N];
        for(int i=0; i<N-1; i++){
            street[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] price = new long[N];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            price[i] = Long.parseLong(st.nextToken());
            pq.offer(price[i]);
            answer += pq.peek() * street[i];
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
