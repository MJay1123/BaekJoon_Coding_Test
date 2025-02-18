package S1.BOJ2178;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    static class Location {
        int x;
        int y;

        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String[] array = str.split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(array[j]);
            }
        }

        bfs(0,0);
        bw.write(map[N-1][M-1] + "\n");
        bw.flush();

        // 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
    }

    public static void bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Location loc = queue.poll();
//            visited[loc.x][loc.y] = true;
            for(int i=0; i<4; i++){
                int nx = loc.x + dirX[i];
                int ny = loc.y + dirY[i];
                if(rangeCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0){
                    queue.offer(new Location(nx, ny));
                    visited[nx][ny] = true;

                    map[nx][ny] = map[loc.x][loc.y] + 1;
                }
            }
        }
    }

    public static boolean rangeCheck(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
