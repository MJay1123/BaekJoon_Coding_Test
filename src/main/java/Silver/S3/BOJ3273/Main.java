package Silver.S3.BOJ3273;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[n];
        int index = 0;
        while(!pq.isEmpty()){
            arr[index++] = pq.poll();
        }
        int x = Integer.parseInt(br.readLine());
        int left = 0;
        int right = n-1;
        while(left < right){
            if(arr[left] + arr[right] == x){
                answer++;
                left++;
            } else if(arr[left] + arr[right] > x){
                right--;
            } else {
                left++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
