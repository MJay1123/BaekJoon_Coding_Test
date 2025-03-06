package Silver.S1.BOJ1932;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정수 삼각형
public class Main {
    static int N;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i; j++){
                triangle[i-1][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                } else if(j==i){
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, triangle[N-1][i]);
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
