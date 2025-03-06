package Silver.S1.BOJ2667;
// 단지 번호 붙이기
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String[] array = str.split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(array[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
                if(count > 0){
                    list.add(count);
                    count = 0;
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

    public static void bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        count++;

        while(!queue.isEmpty()){
            Location loc = queue.poll();
            for(int i=0; i<4; i++){
                int nx = loc.x + move[i][0];
                int ny = loc.y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    count++;
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

    public static void dfs(int x, int y){
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
