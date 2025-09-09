package Gold.G5.BOJ12865;

import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 물품의 수
    static int K;       // 버틸 수 있는 무게
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] weightArray = new int[N];
        int[] valueArray = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            weightArray[i] = weight;
            valueArray[i] = value;
        }
        int maximum = 0;
        int[][] dp = new int[N][K+1];
        for(int j=0; j<=K; j++){
            if(weightArray[0] <= j){
                dp[0][j] = valueArray[0];
                if(dp[0][j] > maximum){
                    maximum = dp[0][j];
                }
            }
        }
        for(int i=1; i<N; i++){
            int weight = weightArray[i];
            int value = valueArray[i];
            for(int j=1; j<=K; j++){
                if(weight <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] > maximum){
                    maximum = dp[i][j];
                }
            }
        }
        bw.write(maximum + "");
        bw.flush();
    }
}
