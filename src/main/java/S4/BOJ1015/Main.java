package S4.BOJ1015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;                       // 배열의 크기
    static int[] A;
    static int[] B;
    static int[] P;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        B = new int[N];
        P = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }
        visited = new boolean[N];
        Arrays.sort(B);
        for(int b=0; b<N; b++){
            for(int a=0; a<N; a++){
                if(B[b] == A[a] && !visited[a]){
                    visited[a] = true;
                    P[a] = b;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : P){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
