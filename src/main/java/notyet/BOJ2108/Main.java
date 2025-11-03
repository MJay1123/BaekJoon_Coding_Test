package notyet.BOJ2108;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[8002];
        int max = -4000;
        int min = 4000;
        int maxCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            min = Math.min(min, num);
            pq.offer(num);
            sum += num;
            arr[num+4000]++;
            maxCount = Math.max(maxCount, arr[num+4000]);
        }
        bw.write((int)Math.round((double)sum/N) + "\n");    // 산술평균
        for(int i=0; i<pq.size()/2; i++){
            pq.poll();
        }
        bw.write(pq.poll() + "\n");     // 중앙값
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<8001; i++){
            if(arr[i] == maxCount){
                list.add(i);
            }
            if(list.size() == 2){
                break;
            }
        }
        bw.write(list.get(list.size()-1)-4000 + "\n");      // 최빈값
        bw.write(max-min + "\n");       // 범위
        bw.flush();
    }
}
