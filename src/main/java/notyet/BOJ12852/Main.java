package notyet.BOJ12852;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        arr[N] = 0;
        queue.offer(N);
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num <= 1){
                break;
            }
            if(num % 3 == 0){
                if(arr[num/3] > arr[num] + 1){
                    arr[num/3] = arr[num] + 1;
                    queue.offer(num/3);
                }
            }
            if(num % 2 == 0){
                if(arr[num/2] > arr[num] + 1) {
                    arr[num/2] = arr[num] + 1;
                    queue.offer(num / 2);
                }
            }
            if(arr[num-1] > arr[num] + 1) {
                arr[num - 1] = arr[num] + 1;
                queue.offer(num - 1);
            }
        }
        System.out.println(Arrays.toString(arr));
        bw.write(arr[1] + "\n");
        bw.flush();
    }
}
