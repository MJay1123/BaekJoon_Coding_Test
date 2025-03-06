package Silver.S1.BOJ2468;
// 안전 영역
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

    static int N;
    static int[][] map;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int maxCount;

    public static void main(String[] args) throws IOException {
        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 물에 잠기지 않는 안전한 영역의 최대 갯수를 구하시오
        int maxLevel = getMaxLevel(map);

        maxCount = 0;
        for(int level = 0; level <= maxLevel; level++){
            int count = 0;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > level && !visited[i][j]){
                        bfs(new Location(i,j), level);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        bw.write(maxCount + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void bfs(Location loc, int level){
        Queue<Location> queue = new LinkedList<>();
        int x = loc.x;
        int y = loc.y;
        queue.add(loc);
        visited[x][y] = true;

        while(!queue.isEmpty()){
            loc = queue.poll();
            x = loc.x;
            y = loc.y;
            for(int i=0; i<4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] > level){
                    queue.add(new Location(nx, ny));
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

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static int getMaxLevel(int[][] map){
        int level = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                level = Math.max(level, map[i][j]);
            }
        }
        return level;
    }
}