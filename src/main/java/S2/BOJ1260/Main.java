package S2.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 정점의 갯수(1~1000)
        int M = Integer.parseInt(st.nextToken());       // 간선의 갯수(1~10000)
        int K = Integer.parseInt(st.nextToken());       // 시작하는 정점의 번호

        int[][] arr = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = makeGraph(arr, N);
        boolean[] visited = new boolean[N+1];
        dfs(K, graph, visited);
    }

    public static void bfs(int num, int[][] graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
    }

    public static void dfs(int num, int[][] graph, boolean[] visited){
        visited[num] = true;
        System.out.print(num + " ");
        for(int next=1; next<graph[0].length; next++){
            if(!visited[next] && graph[num][next] == 1){
                dfs(next, graph, visited);
            }
        }
    }

//    public static void bfs(int num, int[][] graph, boolean[] visited){
//
//    }

    public static int[][] makeGraph(int[][] arr, int N){
        int[][] graph = new int[N+1][N+1];
        for(int x=0; x<arr.length; x++){
            int a1 = arr[x][0];
            int a2 = arr[x][1];
            graph[a1][a2] = 1;
            graph[a2][a1] = 1;
        }
        return graph;
    }
}
