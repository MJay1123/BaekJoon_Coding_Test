package Gold.G5.BOJ10026;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] move = {{1,0}, {0,1},{-1,0},{0,-1}};
    static int normalCount = 0;
    static int redGreenCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine().split("");
        }
        boolean[][] visited = new boolean[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(!visited[r][c]){
                    normalCount++;
                    normalDFS(r, c, arr, visited, arr[r][c]);
                }
            }
        }
        visited = new boolean[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(!visited[r][c]){
                    redGreenCount++;
                    redGreenDFS(r, c, arr, visited, arr[r][c]);
                }
            }
        }
        bw.write(normalCount + " " + redGreenCount);
        bw.flush();
    }
    public static void normalDFS(int r, int c, String[][] arr, boolean[][] visited, String color){
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if(checkRange(nr, nc, arr) && !visited[nr][nc] && arr[nr][nc].equals(color)){
                normalDFS(nr, nc, arr, visited, color);
            }
        }
    }
    public static void redGreenDFS(int r, int c, String[][] arr, boolean[][] visited, String color){
        visited[r][c] = true;
        for(int i=0; i<4; i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if(checkRange(nr, nc, arr) && !visited[nr][nc]){
                if(color.equals("B")){
                    if(arr[nr][nc].equals("B")){
                        redGreenDFS(nr, nc, arr, visited, color);
                    }
                } else {
                    if(!arr[nr][nc].equals("B")){
                        redGreenDFS(nr, nc, arr, visited, color);
                    }
                }
            }
        }
    }
    public static boolean checkRange(int r, int c, String[][] arr){
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
}
