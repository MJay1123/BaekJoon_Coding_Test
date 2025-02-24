package S2.BOJ11724;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class BFS {
    static int N;
    static int M;
    static boolean[][] map;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());                   // N : 정점의 갯수(1~1000)
        M = Integer.parseInt(st.nextToken());                   // M : 간선의 갯수
        map = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = true;
        }
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count++;
                bfs(i);
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && map[now][i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}