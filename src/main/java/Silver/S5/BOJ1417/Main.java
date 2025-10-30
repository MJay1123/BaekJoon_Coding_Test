package Silver.S5.BOJ1417;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int myVote;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        myVote = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=2; i<=N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            int num = pq.poll();
            if(num < myVote){
                break;
            }
            num--;
            myVote++;
            answer++;
            pq.offer(num);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
