package Gold.G5.BOJ1092;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] crane = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> craneQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            crane[i] = Integer.parseInt(st.nextToken());
            craneQueue.offer(crane[i]);
        }
        int M = Integer.parseInt(br.readLine());
        int[] box = new int[M];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> boxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<M; i++){
            box[i] = Integer.parseInt(st.nextToken());
            boxQueue.offer(box[i]);
        }
        while(!boxQueue.isEmpty()){
            move(craneQueue, boxQueue);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void move(PriorityQueue<Integer> craneQueue, PriorityQueue<Integer> boxQueue){
        answer++;
        PriorityQueue<Integer> craneTemp = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> boxTemp = new PriorityQueue<>(Collections.reverseOrder());
        while(!craneQueue.isEmpty()){
            int crane = craneQueue.poll();
            while(!boxQueue.isEmpty()){
                int box = boxQueue.poll();
                if(crane >= box){
                    break;
                }
                if(crane < box){
                    boxTemp.offer(box);
                }
            }
            craneTemp.offer(crane);
        }
        boxQueue = boxTemp;
    }
}
