package G4.BOJ14502;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int N;                       // 지도 세로 크기
    static int M;                       // 지도 가로 크기
    static int[][] map;                 // 지도
    static boolean[][] visited;         // 방문 배열
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        combination(new Location(0,0), 0, 3);

        System.out.println(maxCount);

    }

    public static void combination(Location location, int wall, int count){
        if(wall == count){
            int[][] newMap = new int[N][M];
            boolean[][] newVisited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(visited[i][j]){
                        newMap[i][j] = 3;                   // 빈 공간(0) / 벽(1) / 바이러스(2) / 새로운 벽(3)
                    } else {
                        newMap[i][j] = map[i][j];
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(newMap[i][j] == 2 && !newVisited[i][j]){
                        dfs(i,j, newMap, newVisited);       // dfs를 통해 바이러스를 퍼뜨린다.
                    }
                }
            }

            int sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(newMap[i][j] == 0){                  // 0의 갯수를 센다.
                        sum++;
                    }
                }
            }
            maxCount = Math.max(maxCount, sum);
            return;
        }
        int x = location.x;
        int y = location.y;
        if(!checkRange(x,y)){
            return;
        }
        if(map[x][y] != 0){
            combination(getNextLocation(location), wall, count);
        } else {
            visited[location.x][location.y] = true;
            combination(getNextLocation(location), wall+1, count);
            visited[location.x][location.y] = false;
            combination(getNextLocation(location), wall, count);
        }
    }

    public static void dfs(int x, int y, int[][] map, boolean[][] visited){
        visited[x][y] = true;
        map[x][y] = 2;
        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0){
                dfs(nx, ny, map, visited);
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
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static Location getNextLocation(Location location){
        int x = location.x;
        int y = location.y;
        int nx = x+1;
        int ny = y;
        if(nx == N){
            nx -= N;
            ny++;
        }
        return new Location(nx, ny);
    }
}