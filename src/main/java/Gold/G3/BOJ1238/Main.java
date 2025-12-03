package Gold.G3.BOJ1238;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(arr[i], 1000000);
        }
        for(int i=1; i<=N; i++){
            arr[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int country1 = Integer.parseInt(st.nextToken());
            int country2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[country1][country2] = time;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, arr[i][X] + arr[X][i]);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
