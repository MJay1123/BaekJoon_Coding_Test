package Silver.S2.BOJ2805;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나무 자르기
public class Main {
    static int N;           // 나무의 수
    static int M;           // 가져갈 나무 길이
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            pq.offer(trees[i]);
        }
        int sum = 0;
        int index = 0;
        while(true){
            int current = pq.poll();
            index++;
            int next = (!pq.isEmpty()) ? pq.peek() : 0;
            for(int i=current-1; i>=next; i--){
                sum += index;
                if(sum >= M){
                    answer = i;
                    break;
                }
            }
            if(sum >= M){
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
