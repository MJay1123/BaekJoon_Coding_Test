package Silver.S2.BOJ24479;

import java.io.*;
import java.util.*;

public class Main {
    static int visitedNumber = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 수
        int M = Integer.parseInt(st.nextToken());   // 간선의 수
        int R = Integer.parseInt(st.nextToken());   // 시작 정점
        PriorityQueue<Integer>[] connectionList = new PriorityQueue[N+1];
        for(int i=1; i<=N; i++){
            connectionList[i] = new PriorityQueue<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            connectionList[node1].add(node2);
            connectionList[node2].add(node1);
        }
        int[] visited = new int[N+1];
        DFS(R, connectionList, visited);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(visited[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void DFS(int start, PriorityQueue<Integer>[] connectionList, int[] visited){
        visited[start] = visitedNumber;
        visitedNumber++;
        PriorityQueue<Integer> pq = connectionList[start];
        while(!pq.isEmpty()){
            int next = pq.poll();
            if(visited[next] == 0){
                DFS(next, connectionList, visited);
            }
        }
    }
}
