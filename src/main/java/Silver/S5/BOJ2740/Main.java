package Silver.S5.BOJ2740;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = new int[N][K];
        for(int r=0; r<N; r++){
            for(int c=0; c<K; c++){
                int sum = 0;
                for(int i=0; i<M; i++){
                    sum += A[r][i] * B[i][c];
                }
                result[r][c] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
