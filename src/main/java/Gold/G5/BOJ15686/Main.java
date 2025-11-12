package Gold.G5.BOJ15686;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int answer = Integer.MAX_VALUE;
    static int chickenDistance;
    static int[][] map;
    static boolean[][] visited;
    static List<Location> houseList;
    static List<Location> chickenList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    houseList.add(new Location(i, j));
                } else if(map[i][j] == 2){
                    chickenList.add(new Location(i, j));
                    map[i][j] = 0;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        combination(list, 0, 0, M);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void combination(List<Integer> choose, int index, int depth, int M){
        if(depth == M){
            chickenDistance = 0;
            for(int i : choose){
                int r = chickenList.get(i).r;
                int c = chickenList.get(i).c;
                map[r][c] = 2;
            }
            for(Location loc : houseList){
                chickenDistance += getChickenDistance(loc);
            }
            for(int i : choose){
                int r = chickenList.get(i).r;
                int c = chickenList.get(i).c;
                map[r][c] = 0;
            }
            answer = Math.min(answer, chickenDistance);
            return;
        }
        if(index == chickenList.size()){
            return;
        }
        choose.add(index);
        combination(choose, index+1, depth+1, M);
        choose.remove(choose.size()-1);
        combination(choose, index+1, depth, M);
    }
    public static int getChickenDistance(Location loc){
        visited = new boolean[N][N];
        int r = loc.r;
        int c = loc.c;
        visited[r][c] = true;
        int startR = r;
        int startC = c;
        Queue<Location> queue = new LinkedList<>();
        queue.offer(loc);
        while(!queue.isEmpty()){
            loc = queue.poll();
            r = loc.r;
            c = loc.c;
            for(int i=0; i<4; i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(checkRange(nr, nc) && !visited[nr][nc]){
                    if(map[nr][nc] == 2){
                        return getDistance(startR, startC, nr, nc);
                    } else {
                        visited[nr][nc] = true;
                        queue.offer(new Location(nr, nc));
                    }
                }
            }
        }
        return -1;
    }

    public static int getDistance(int r1, int c1, int r2, int c2){
        return Math.max(r1, r2) - Math.min(r1, r2) + Math.max(c1, c2) - Math.min(c1, c2);
    }

    static class Location {
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
