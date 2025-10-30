package Gold.G4.BOJ11000;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> classes = new PriorityQueue<>(new Comparator<int[]>(){ // 수업은 시작 시간이 빠른 것부터
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = end;
            classes.offer(arr);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){  // 먼저 끝나는 수업부터 처리
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        pq.offer(classes.poll());
        answer++;
        while(!classes.isEmpty()){
            int[] arr = classes.poll();
            while(!pq.isEmpty()){
                if(pq.peek()[1] <= arr[0]){
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.offer(arr);
            answer = Math.max(answer, pq.size());
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
