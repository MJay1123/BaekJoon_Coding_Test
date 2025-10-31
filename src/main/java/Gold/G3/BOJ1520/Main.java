package Gold.G3.BOJ1520;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[M][N];
        int[][] dp = new int[M][N];
        dp[M-1][N-1] = 1;
        DFS(0, 0, map, visited, dp);
        bw.write(dp[0][0] + "\n");
        bw.flush();
    }

    public static void DFS(int r, int c, int[][] map, boolean[][] visited, int[][] dp){
        if(r == map.length-1 && c == map[0].length-1){
            return;
        }
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if(checkRange(nr, nc, map) && map[nr][nc] < map[r][c]){
                if(!visited[nr][nc]){
                    DFS(nr, nc, map, visited, dp);
                }
                dp[r][c] += dp[nr][nc];
            }
        }
    }

    public static boolean checkRange(int r, int c, int[][] map){
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
}
