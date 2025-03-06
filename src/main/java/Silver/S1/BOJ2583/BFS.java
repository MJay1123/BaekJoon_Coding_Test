package Silver.S1.BOJ2583;

import java.io.*;
import java.util.*;

public class BFS {

    static int M;                                           // 지도 세로 길이
    static int N;                                           // 지도 가로 길이
    static int K;                                           // 직사각형의 개수
    static int count;                                       // count
    static int[][] map;                                     // 지도
    static boolean[][] visited;                             // 방문 배열
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};      // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    map[j][i] = 1;
                }
            }
        }
        visited = new boolean[M][N];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    count = 0;
                    bfs(new Location(i,j));
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        bw.write(list.size() + "\n");
        for(int i : list){
            bw.write(i + " ");
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

        while(!queue.isEmpty()){
            loc = queue.poll();
            x = loc.x;
            y = loc.y;
            for(int i=0; i<4; i++){
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < M && y >= 0 && y < N);
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