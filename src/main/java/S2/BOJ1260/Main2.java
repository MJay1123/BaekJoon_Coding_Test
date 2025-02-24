package S2.BOJ1260;

import java.io.*;
import java.util.*;

// DFS와 BFS
public class Main2 {

    static int N;                                       // N : 정점의 개수(1~1000)
    static int M;                                       // M : 간선의 개수(1~10000)
    static int V;                                       // V : 탐색을 시작할 정점의 번호
    static boolean[][] connectionMap;                   // 연결 구조 이중 배열
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        connectionMap = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connectionMap[a][b] = true;
            connectionMap[b][a] = true;
        }

        // DFS 구현
        visited = new boolean[N+1];                     // 방문 배열
        dfs(V);
        sb.append("\n");

        // BFS 구현
        visited = new boolean[N+1];
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int start){
        sb.append(start).append(" ");
        visited[start] = true;
        for(int i=1; i<=N; i++){
            if(connectionMap[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int num = queue.poll();
            visited[num] = true;
            sb.append(num).append(" ");
            for(int i=1; i<=N; i++){
                if(connectionMap[num][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}