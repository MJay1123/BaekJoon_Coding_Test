package Silver.S4.BOJ11047;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        while(true){
            int coin = pq.poll();
            if(K / coin > 0){
                int count = K / coin;
                answer += count;
                K -= coin * count;
            }
            if(K == 0){
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
