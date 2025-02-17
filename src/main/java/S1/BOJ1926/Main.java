package S1.BOJ1926;
// 그림
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // n : 세로 길이
        int m = Integer.parseInt(st.nextToken());       // m : 가로 길이
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int maxArea = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                int drawingArea = 0;
                if(!visited[i][j] && map[i][j] == 1){
                    drawingArea = dfs(i, j, drawingArea, map, visited);
                    count++;
                    maxArea = Math.max(maxArea, drawingArea);
                }
            }
        }
        bw.write(count + "\n");
        bw.write(maxArea + "\n");
        bw.flush();
    }

    public static int dfs(int x, int y, int count, int[][] map, boolean[][] visited){
        visited[x][y] = true;
        count++;
        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i<delta.length; i++){
            int xx = x + delta[i][0];
            int yy = y + delta[i][1];
            if(xx >= map.length || xx < 0 || yy >= map[0].length || yy < 0){
                continue;
            }
            if(!visited[xx][yy] && map[xx][yy] == 1){
                count = dfs(xx, yy, count, map, visited);
            }
        }
        return count;
    }
}
