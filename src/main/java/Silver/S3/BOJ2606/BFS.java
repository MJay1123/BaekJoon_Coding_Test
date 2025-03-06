package Silver.S3.BOJ2606;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

    static int computer;
    static int connection;
    static boolean[][] connections;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());

        visited = new boolean[computer + 1];
        connections = new boolean[computer + 1][computer + 1];
        for (int i = 0; i < connection; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections[a][b] = connections[b][a] = true;
        }

        bfs(1);
        bw.write(count + "\n");
        bw.flush();

    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i=1; i<=computer; i++){
                if(!visited[i] && connections[num][i]){
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}