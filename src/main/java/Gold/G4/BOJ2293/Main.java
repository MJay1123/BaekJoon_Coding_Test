package Gold.G4.BOJ2293;

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
        for(int i=0; i<n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if(coin <= k) {
                pq.offer(coin);
            }
        }
        n = pq.size();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = pq.poll();
        }
        int[][] arr = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            arr[i][coin] = 1;
            for (int j = coin + 1; j <= k; j++) {
                int sum = 0;
                for (int a = 0; a <= i; a++) {
                    sum += arr[a][j - coin];
                }
                arr[i][j] = sum;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arr[i][k];
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
