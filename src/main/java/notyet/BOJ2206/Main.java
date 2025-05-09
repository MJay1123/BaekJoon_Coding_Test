package notyet.BOJ2206;

import java.io.*;
import java.util.*;

public class Main {

    static int N;               // 지도의 세로 길이
    static int M;               // 지도의 가로 길이
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int minDistance;
    static List<Location> wall = new ArrayList<Location>();

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
                if(map[i][j] == 1){
                    wall.add(new Location(i,j));
                    map[i][j] = -1;
                }
            }
        }
        visited = new boolean[N][M];

        // 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.
        // 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
        // 불가능할 때는 -1을 출력한다

        minDistance = Integer.MAX_VALUE;

        for(int w=0; w<wall.size(); w++){
            Location loc = wall.get(w);
            int x = loc.x;
            int y = loc.y;
            map[x][y] = 0;                          // 벽 1개 부수기
            visited = new boolean[N][M];
            bfs(0,0);

            if(map[N-1][M-1] != 0){                                         // 0이라면 BFS가 이루어지지 않음
                minDistance = Math.min(minDistance, map[N-1][M-1]);         // BFS가 이루어진 후에 거리 반환
            }
            map[x][y] = -1;                          // 벽 복원
        }
        if(minDistance == Integer.MAX_VALUE){
            bw.write(-1 + "\n");
        } else {
            bw.write(minDistance + "\n");
        }
        bw.flush();
    }

    public static void bfs(int x, int y){               // (x,y)에서 출발하는 BFS
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        map[x][y] = 1;

        while(!queue.isEmpty()){               // N,M 좌표에 도달하면 즉시 중단
            Location loc = queue.poll();
            for(int i=0; i<4; i++){
                int nx = loc.x + move[i][0];
                int ny = loc.y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != -1){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[loc.x][loc.y] + 1;
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
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
