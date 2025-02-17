package S2.BOJ11724;

import java.io.*;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N : 정점의 갯수
        int M = Integer.parseInt(st.nextToken());           // M : 간선의 갯수
        int[][] connection = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            connection[i][0] = Integer.parseInt(st.nextToken());
            connection[i][1] = Integer.parseInt(st.nextToken());
        }

        // 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
        boolean[][] connectionMap = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            int a =connection[i][0];
            int b =connection[i][1];
            connectionMap[a][b] = true;
            connectionMap[b][a] = true;
        }
        boolean[] visited = new boolean[N+1];
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i, connectionMap, visited);
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static void dfs(int start, boolean[][] connectionMap, boolean[] visited){
        visited[start] = true;
        for(int i=0; i<visited.length; i++){
            if(connectionMap[start][i] && !visited[i]){
                dfs(i, connectionMap, visited);
            }
        }
    }
}
