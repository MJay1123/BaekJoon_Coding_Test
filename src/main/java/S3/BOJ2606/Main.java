package S3.BOJ2606;

// 바이러스
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());        // n : 컴퓨터의 수
        int t = Integer.parseInt(br.readLine());        // t : 컴퓨터 연결의 수
        int[][] arr = new int[t][2];
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n+1];
        boolean[][] connection = new boolean[n+1][n+1];
        for(int i=0; i<t; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            connection[a][b] = true;
            connection[b][a] = true;
        }

        dfs(1, connection, visited);
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]){
                count++;
            }
        }
        System.out.println(count-1);
    }

    public static void dfs(int num, boolean[][] connection, boolean[] visited){
        visited[num] = true;
        for(int i=0; i<visited.length; i++){
            if(visited[i] == false && connection[num][i] == true){
                dfs(i, connection, visited);
            }
        }
    }
}
