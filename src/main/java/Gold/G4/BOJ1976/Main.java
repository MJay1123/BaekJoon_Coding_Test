package Gold.G4.BOJ1976;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] connection = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                connection[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 플로이드 워셜 방식 사용
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(connection[i][j] == 1){
                        continue;
                    }
                    if(i == j){
                        connection[i][j] = 1;
                    }
                    if(connection[i][k] + connection[k][j] == 2){
                        connection[i][j] = 1;
                        connection[j][i] = 1;
                    }
                }
            }
        }
        boolean answer = true;
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i=1; i<M; i++){
            int next = Integer.parseInt(st.nextToken());
            if(connection[prev][next] == 0){
                answer = false;
                break;
            }
            prev = next;
        }
        bw.write(answer ? "YES" : "NO");
        bw.flush();
    }
}
