package S1.BOJ2667;

import java.io.*;
import java.util.*;

public class BFS {

    static int N;                           // 지도의 한 면 길이
    static int[][] map;                     // 지도
    static boolean[][] visited;             // 방문 배열
    static int count;                       // count...?
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();         // 단지 크기들을 담을 리스트
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count = 0;
                    bfs(new Location(i,j));
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for(int i : list){
            bw.write(i + "\n");
        }
        bw.flush();
    }

    public static void bfs(Location loc){
        Queue<Location> queue = new LinkedList<>();
        queue.add(loc);
        int x = loc.x;
        int y = loc.y;
        visited[x][y] = true;
        count++;

        while(!queue.isEmpty()) {
            loc = queue.poll();
            x = loc.x;
            y = loc.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
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