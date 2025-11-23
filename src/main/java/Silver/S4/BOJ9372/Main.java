package Silver.S4.BOJ9372;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            answer = 10000000;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] airplane = new int[N+1][N+1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                airplane[a][b] = 1;
                airplane[b][a] = 1;
            }
            boolean[] visited = new boolean[N+1];
            count = 0;
            DFS(1, airplane, visited);
            answer = Math.min(answer, count);
            bw.write(answer + "\n");
        }
        bw.flush();
    }

    public static void DFS(int n, int[][] arr, boolean[] visited){
        visited[n] = true;
        for(int i=1; i<visited.length; i++){
            if(!visited[i] && arr[n][i] == 1){
                count++;
                DFS(i, arr, visited);
            }
        }
    }
}
