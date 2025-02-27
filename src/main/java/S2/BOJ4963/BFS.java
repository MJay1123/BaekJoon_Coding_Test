package S2.BOJ4963;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

    static int w;                   // 지도의 너비
    static int h;                   // 지도의 높이
    static int[][] map;             // 지도 배열
    static boolean[][] visited;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0){       // 마지막 0 0을 받으면 반복 중단
                break;
            }
            map = new int[h][w];        // 1은 땅, 0은 바다
            visited = new boolean[h][w];
            count = 0;
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        count++;
                        bfs(i, j);
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
    }

    public static boolean checkRange(int x, int y){
        return (x>=0 && x<h && y>=0 && y<w);
    }

    public static void bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Location(x, y));
        int nx = 0;
        int ny = 0;
        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            for (int i = 0; i < 8; i++) {
                nx = loc.x + move[i][0];
                ny = loc.y + move[i][1];
                if (checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new Location(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}