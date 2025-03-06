package Silver.S2.BOJ1260;

import java.io.*;
import java.util.*;

// DFS와 BFS
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // N : 정점의 개수(1~1000)
        int M = Integer.parseInt(st.nextToken());       // M : 간선의 개수(1~10000)
        int V = Integer.parseInt(st.nextToken());       // V : 탐색을 시작할 정점의 번호
        int[][] connection = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            connection[i][0] = Integer.parseInt(st.nextToken());
            connection[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[][] connectionMap = new boolean[N+1][N+1];
        for(int i=0; i<connection.length; i++){
            int a = connection[i][0];
            int b = connection[i][1];
            connectionMap[a][b] = true;
            connectionMap[b][a] = true;
        }

        // DFS 구현
        boolean[] visited = new boolean[N+1];           // 방문 배열
        List<Integer> result = new ArrayList<>();       // 결과값 리스트
        dfs(V, connectionMap, visited, result);

        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }
        bw.write(sb.toString().trim() + "\n");
        bw.flush();

        // BFS 구현
        visited = new boolean[N+1];                     // 방문 배열
        result = new ArrayList<>();                     // 결과값 리스트
        Queue<Integer> queue = new LinkedList<>();      // BFS용 Queue
        queue.offer(V);                                 // 시작점 세팅
        bfs(connectionMap, visited, queue, result);

        sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }
        bw.write(sb.toString().trim() + "\n");
        bw.flush();
    }

    public static void bfs(boolean[][] connectionMap, boolean[] visited, Queue<Integer> queue, List<Integer> result){
        int start = queue.poll();
        if(visited[start] == false) {
            visited[start] = true;
            result.add(start);
        }

        for(int i=0; i<visited.length; i++){
            if(connectionMap[start][i] == true && visited[i] == false){
                queue.offer(i);
            }
        }
        if(queue.isEmpty() == false){
            bfs(connectionMap, visited, queue, result);
        }
    }

    public static void dfs(int start, boolean[][] connectionMap, boolean[] visited, List<Integer> result){
        visited[start] = true;
        result.add(start);

        for(int i=0; i<visited.length; i++){
            if(connectionMap[start][i] == true && visited[i] == false){
                dfs(i, connectionMap, visited, result);
            }
        }
    }
}
