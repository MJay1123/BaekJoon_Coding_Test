package Gold.G5.BOJ2470;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = pq.poll();
        }
        int left = 0;
        int right = N-1;
        int[] answer = new int[3];
        answer[0] = Integer.MAX_VALUE;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(answer[0]) > Math.abs(sum)){
                answer[0] = sum;
                answer[1] = arr[left];
                answer[2] = arr[right];
            }
            if(sum == 0){
                break;
            }
            if(sum < 0){
                left++;
            } else {
                right--;
            }
        }
        bw.write(answer[1] + " " + answer[2]);
        bw.flush();
    }
}
