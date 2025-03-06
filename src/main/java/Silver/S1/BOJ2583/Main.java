package Silver.S1.BOJ2583;
// 영역 구하기
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());       // M : 종이의 세로 길이
        int N = Integer.parseInt(st.nextToken());       // N : 종이의 가로 길이
        int K = Integer.parseInt(st.nextToken());       // K : 직사각형의 갯수
        boolean[][] map = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];

        int[][] arr = new int[K][4];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<arr.length; i++){
            for(int x=arr[i][0]; x<arr[i][2]; x++){
                for(int y=arr[i][1]; y<arr[i][3]; y++){
                    map[x][y] = true;
                }
            }
        }

        int count = 0;
        List<Integer> areaList = new ArrayList<>();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == false && visited[i][j] == false){
                    List<Integer> list = new ArrayList<>();
                    dfs(i, j, map, visited, list);
                    areaList.add(list.size());
                }
            }
        }
        Collections.sort(areaList);
        bw.write(areaList.size() + "\n");
        bw.flush();
        StringBuilder sb = new StringBuilder();
        for(int k : areaList){
            sb.append(k).append(" ");
        }
        sb.trimToSize();
        bw.write(sb.toString() + "\n");
        bw.flush();
    }

    public static void dfs(int x, int y, boolean[][] map, boolean[][] visited, List<Integer> list){
        visited[x][y] = true;
        list.add(1);
        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i<delta.length; i++){
            int xx = x + delta[i][0];
            int yy = y + delta[i][1];
            if(xx >= map.length || xx < 0 || yy >= map[0].length || yy < 0){
                continue;
            }
            if(map[xx][yy] == true){
                continue;
            }
            if(visited[xx][yy] == true){
                continue;
            }
            dfs(xx, yy, map, visited, list);
        }
    }
}
