package Gold.G4.BOJ14502;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// 연구소
public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{1,0}, {-1,0}, {0,1},{0,-1}};
    static int maxSafe = 0;


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
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.

        combination(map, visited, new Location(0,0), 0);

        bw.write(maxSafe + "\n");
        bw.flush();
    }

    public static void dfs(int[][] map, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        map[x][y] = 2;
        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0){
                dfs(map, visited, nx, ny);
            }
        }
    }

    public static void combination(int[][] map, boolean[][] visited, Location loc, int depth){
        if(depth == 3){
            int[][] newMap = new int[N][M];                     // 벽을 세운 새로운 맵 생성
            boolean[][] newVisited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(visited[i][j]){
                        newMap[i][j] = 3;                       // 새로운 벽은 3으로 함
                    } else {
                        newMap[i][j] = map[i][j];
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(newMap[i][j] == 2 && !newVisited[i][j]){
                        dfs(newMap, newVisited, i, j);          // 바이러스가 퍼진 뒤(2)
                    }
                }
            }
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(newMap[i][j] == 0){                      // 0의 갯수 세기(안전 영역)
                        count++;
                    }
                }
            }
            maxSafe = Math.max(maxSafe, count);
            return;
        }

        if(!checkRange(loc.x, loc.y)){                          // 범위를 넘어간 케이스는 폐기
            return;
        }

        int x = loc.x;
        int y = loc.y;

        if(map[x][y] != 0){                                     // 벽이라면 다음으로 이동
            combination(map, visited, getNextLocation(loc), depth);
        } else {
            visited[x][y] = true;
            combination(map, visited, getNextLocation(loc), depth + 1);

            visited[x][y] = false;
            combination(map, visited, getNextLocation(loc), depth);
        }
    }

    public static Location getNextLocation(Location loc){       // 다음 좌표 받아오기
        int x = loc.x;
        int y = loc.y;

        x++;
        if(x == N){
            x -= N;
            y++;
        }
        return new Location(x, y);
    }

    public static boolean checkRange(int x, int y){             // array 범위 확인
        return (x >= 0 && x < N && y >= 0 && y < M);
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
