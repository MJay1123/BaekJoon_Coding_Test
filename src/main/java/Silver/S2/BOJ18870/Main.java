package Silver.S2.BOJ18870;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbersArray = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> smallCountMap = new HashMap<>();
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            numbersArray[i] = number;
            pq.offer(number);
        }
        int sum = 0;
        while(!pq.isEmpty()){
            int number = pq.poll();
            if(!smallCountMap.containsKey(number)){
                smallCountMap.put(number, sum);
                sum++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(smallCountMap.get(numbersArray[i]));
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
