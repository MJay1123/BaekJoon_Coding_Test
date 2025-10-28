package Gold.G4.BOJ1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(true){
            if(pq.size() == 1){
                break;
            }
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;
            answer += sum;
            pq.offer(sum);
       }
        bw.write(answer + "\n");
        bw.flush();
    }
}
