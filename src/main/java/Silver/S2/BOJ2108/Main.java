package Silver.S2.BOJ2108;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        bw.write(average(arr) + "\n");
        bw.write(middle(arr) + "\n");
        bw.write(most(arr) + "\n");
        bw.write(range(arr) + "\n");
        bw.flush();
    }
    public static int average(int[] arr){
        double sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return (int) round(sum / arr.length);
    }
    public static int middle(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
        }
        int mid = pq.size()/2;
        for(int i=0; i<mid; i++){
            pq.poll();
        }
        return pq.poll();
    }
    public static int most(int[] arr){
        int[] count = new int[8002];
        int maxCount = 0;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            count[num + 4000]++;
            maxCount = Math.max(maxCount, count[num+4000]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<8002; i++){
            if(count[i] == maxCount){
                list.add(i-4000);
            }
        }
        if(list.size() == 1){
            return list.get(0);
        } else {
            return list.get(1);
        }
    }
    public static int range(int[] arr){
        int max = -4000;
        int min = 4000;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max-min;
    }
}
