package Gold.G5.BOJ7569;

import java.io.*;
import java.util.*;

public class Main {
    static boolean possible = true;
    static int max = 0;
    static int[][] move = {{0,0,1}, {0,0,-1}, {0,1,0}, {0,-1,0}, {1,0,0}, {-1,0,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[N][M][H];
        List<Location> ripenTomato = new ArrayList<>();
        for(int h=0; h<H; h++){
            for(int r=0; r<N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<M; c++){
                    tomato[r][c][h] = Integer.parseInt(st.nextToken());
                    if(tomato[r][c][h] == 1){
                        ripenTomato.add(new Location(r, c, h));
                    }
                }
            }
        }
        boolean[][][] visited = new boolean[N][M][H];
        BFS(tomato, visited, ripenTomato);
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                for(int h=0; h<H; h++){
                    if(tomato[r][c][h] == 0){
                        possible = false;
                    }
                    max = Math.max(max, tomato[r][c][h]-1);
                }
            }
        }
        if(possible){
            bw.write(max + "\n");
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
    }

    public static void BFS(int[][][] tomato, boolean[][][] visited, List<Location> list){
        Queue<Location> queue = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            Location loc = list.get(i);
            queue.offer(loc);
            int r = loc.r;
            int c = loc.c;
            int h = loc.h;
            visited[r][c][h] = true;
        }
        while(!queue.isEmpty()){
            Location loc = queue.poll();
            int r = loc.r;
            int c = loc.c;
            int h = loc.h;
            for(int i=0; i<move.length; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                int nh = h + move[i][2];
                if(checkRange(tomato, nr, nc, nh) && tomato[nr][nc][nh] >= 0){
                    if(tomato[nr][nc][nh] == 0){
                        tomato[nr][nc][nh] = tomato[r][c][h] + 1;
                    } else if(tomato[nr][nc][nh] > 0){
                        tomato[nr][nc][nh] = Math.min(tomato[nr][nc][nh], tomato[r][c][h]+1);
                    }
                    if(!visited[nr][nc][nh]){
                        visited[nr][nc][nh] = true;
                        loc = new Location(nr, nc, nh);
                        queue.offer(loc);
                    }
                }
            }
        }
    }

    public static boolean checkRange(int[][][] tomato, int r, int c, int h){
        return r >= 0 && c >= 0 && h >= 0 && r < tomato.length && c < tomato[0].length && h < tomato[0][0].length;
    }

    static class Location {
        int r;
        int c;
        int h;
        public Location(int r, int c, int h){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}
