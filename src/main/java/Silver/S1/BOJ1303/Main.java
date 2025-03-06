package Silver.S1.BOJ1303;


import java.io.*;
import java.util.StringTokenizer;

// 전쟁 - 전투
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N : 가로 길이
        int M = Integer.parseInt(st.nextToken());           // M : 세로 길이

        // N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다

        String[][] map = new String[M][N];
        for(int i=0; i<M; i++){
            String str = br.readLine();
            String[] array = str.split("");
            for(int j=0; j<array.length; j++){
                map[i][j] = array[j];
            }
        }
        boolean[][] visited = new boolean[M][N];
        int wPower = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(!visited[i][j] && map[i][j].equals("W")){
                    int count = 0;
                    count = dfs(i, j, map, "W", visited, count);
                    wPower += count*count;
                }
            }
        }
        visited = new boolean[M][N];
        int bPower = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(!visited[i][j] && map[i][j].equals("B")){
                    int count = 0;
                    count = dfs(i, j, map, "B", visited, count);
                    bPower += count*count;
                }
            }
        }
        bw.write(wPower + " " + bPower);
        bw.flush();
    }

    public static int dfs(int x, int y, String[][] map, String target, boolean[][] visited, int count){
        visited[x][y] = true;
        count++;
        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i<delta.length; i++){
            int xx = x + delta[i][0];
            int yy = y + delta[i][1];
            if(xx >= map.length || xx < 0 || yy >= map[0].length || yy < 0){
                continue;
            }
            if(map[xx][yy].equals(target) && !visited[xx][yy]){
                count = dfs(xx, yy, map, target, visited, count);
            }
        }
        return count;
    }
}
