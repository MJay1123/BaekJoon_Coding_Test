package Gold.G5.BOJ2294;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            if (coin <= k){
                pq.offer(coin);
            }
        }
        n = pq.size();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = pq.poll();
        }
        int[] arr = new int[k+1];
        for(int i=0; i<coins.length; i++){
            int coin = coins[i];
            arr[coin] = 1;
            for(int j=coin; j<=k; j++){
                if(arr[j-coin] > 0){
                    if(arr[j] == 0) {
                        arr[j] = arr[j-coin]+1;
                    } else {
                        arr[j] = Math.min(arr[j], arr[j-coin]+1);
                    }
                }
            }
        }
        if(arr[k] == 0){
            bw.write(-1 + "\n");
        } else {
            bw.write(arr[k] + "\n");
        }
        bw.flush();
    }
}
