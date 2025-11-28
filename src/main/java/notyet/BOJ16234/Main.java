package notyet.BOJ16234;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int sum = 0;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bfs(i, j);
                if(count > 0){
                    System.out.println(sum);
                    System.out.println(count);
                }
            }
        }
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    map[i][j] = sum / count;
                }
            }
        }
        visited = new boolean[N][N];
        sum = 0;
        count = 0;
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static void bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(!visited[x][y] && rangeCheck(nx, ny) && differenceCheck(x, y, nx, ny)){
                queue.add(new Location(x, y));
                visited[x][y] = true;
                count++;
                sum += map[x][y];
                break;
            }
        }

        while(!queue.isEmpty()){
            Location loc = queue.poll();
            for(int i=0; i<4; i++){
                int nx = loc.x + move[i][0];
                int ny = loc.y + move[i][1];
                if(rangeCheck(nx, ny) && !visited[nx][ny] && differenceCheck(loc.x, loc.y, nx, ny)){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                    sum += map[nx][ny];
                }
            }

        }
    }

    public static boolean differenceCheck(int x1, int y1, int x2, int y2){
        int difference = Math.abs(map[x1][y1] - map[x2][y2]);
        return difference >= L && difference <= R;
    }

    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
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
