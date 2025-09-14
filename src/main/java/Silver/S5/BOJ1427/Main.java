package Silver.S5.BOJ1427;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(true){
            int digit = num % 10;
            pq.offer(digit);
            num /= 10;
            if(num == 0){
                break;
            }
        }
        int answer = 0;
        while(!pq.isEmpty()){
            answer *= 10;
            int digit = pq.poll();
            answer += digit;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
