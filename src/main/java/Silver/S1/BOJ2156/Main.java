package Silver.S1.BOJ2156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cups = new int[n];
        for(int i=0; i<n; i++){
            cups[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(i == 0){
                dp[i] = cups[i];
            } else if(i == 1){
                dp[i] = cups[i-1] + cups[i];
            } else if(i == 2){
                dp[i] = Math.max(dp[i-1], Math.max(cups[i-2], cups[i-1])+cups[i]);
            } else {
                dp[i] = Math.max(dp[i - 3] + cups[i - 1] + cups[i], Math.max(dp[i - 2] + cups[i], dp[i - 1]));
            }
        }
        bw.write(dp[n-1] + "\n");
        bw.flush();
    }
}
