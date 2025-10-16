package Silver.S2.BOJ1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] maxSum = new int[2][n];
        maxSum[0][0] = -10000;
        maxSum[1][0] = arr[0];
        if(n >= 2) {
            for (int i=1; i<n; i++) {
                maxSum[0][i] = Math.max(maxSum[0][i-1], maxSum[1][i-1]);
                maxSum[1][i] = Math.max(arr[i], maxSum[1][i-1] + arr[i]);
            }
        }
        int answer = -10000;
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                answer = Math.max(answer, maxSum[i][j]);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
