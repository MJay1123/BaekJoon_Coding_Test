package Silver.S1.BOJ7562;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;                   // 테스트 케이스 개수
    static int I;                   // 체스판 길이
    static Location start;
    static Location end;            // 도착점
    static int[][] move = {{1,2},{2,1},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            map = new int[I][I];
            visited = new boolean[I][I];

            bfs(new Location(startX, startY));
            bw.write(map[endX][endY] + "\n");
        }
        bw.flush();
    }

    public static void bfs(Location loc){
        Queue<Location> queue = new LinkedList<>();
        queue.add(loc);
        int x = loc.x;
        int y = loc.y;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            loc = queue.poll();
            x = loc.x;
            y = loc.y;
            for(int i=0; i<8; i++){
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny]){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                    } else {
                        map[nx][ny] = Math.min(map[nx][ny], map[x][y] + 1);
                    }
                }
            }
        }
    }

    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < I && y >= 0 && y < I);
    }
}