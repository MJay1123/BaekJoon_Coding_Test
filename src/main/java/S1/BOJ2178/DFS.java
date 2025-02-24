package S1.BOJ2178;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS {

    static int N;                                           // 지도 세로 길이
    static int M;                                           // 지도 가로 길이
    static int[][] map;                                     // 지도
    static boolean[][] visited;                             // 방문 배열
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};      // 상하좌우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        visited = new boolean[N][M];

        // 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸
        // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
        dfs(0,0);
        bw.write(map[N-1][M-1] + "\n");
        bw.flush();
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (checkRange(nx, ny) && map[nx][ny] != 0) {           // dfs 과정에서 최솟값으로 변경하려 방문배열 고려 X
                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y] + 1;
                } else {
                    map[nx][ny] = Math.min(map[nx][ny], map[x][y] + 1);         // 최소 거리로 변경
                }
            }
        }
        for(int i=0; i<4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx,ny) && !visited[nx][ny] && map[nx][ny] != 0){
                dfs(nx, ny);
            }
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < M);
    }



}