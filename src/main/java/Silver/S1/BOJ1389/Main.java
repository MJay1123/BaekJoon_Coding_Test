package Silver.S1.BOJ1389;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] connection = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            connection[num1][num2] = true;
            connection[num2][num1] = true;
        }
        int[][] arr = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                if(connection[i][j]){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 10000;
                }
            }
        }
        for(int k=1; k<=N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int baconNumber = Integer.MAX_VALUE;
        int index = 0;
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                if(i == j || arr[i][j] == 10000){
                    continue;
                }
                sum += arr[i][j];
            }
            if(baconNumber > sum){
                baconNumber = sum;
                index = i;
            }
        }
        bw.write(index + "\n");
        bw.flush();
    }
}
