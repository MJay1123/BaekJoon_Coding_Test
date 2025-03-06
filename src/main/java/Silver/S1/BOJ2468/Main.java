package Silver.S1.BOJ2468;

// 안전 영역
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 물에 잠기지 않는 안전한 영역의 최대 갯수를 구하시오
        int maxLevel = getMaxLevel(arr);
        int maxCount = 0;
        for(int level = 0; level <= maxLevel; level++){
            int count = 0;
            int[][] map = makeMap(level, arr);

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(map[i][j] == 1){
                        dfs(i,j,map);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        bw.write(maxCount + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public static int getMaxLevel(int[][] arr){
        int level = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                level = Math.max(level, arr[i][j]);
            }
        }
        return level;
    }

    public static void dfs(int x, int y, int[][] map){
        map[x][y] = 0;

        if(x+1 < map.length){
            if(map[x+1][y] == 1){
                dfs(x+1, y, map);
            }
        }
        if(x-1 >= 0){
            if(map[x-1][y] == 1){
                dfs(x-1, y, map);
            }
        }
        if(y+1 < map[0].length){
            if(map[x][y+1] == 1){
                dfs(x, y+1, map);
            }
        }
        if(y-1 >= 0){
            if(map[x][y-1] == 1){
                dfs(x, y-1, map);
            }
        }
    }

    public static int[][] makeMap(int level, int[][] arr){
        int[][] newMap = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] <= level){
                    newMap[i][j] = 0;           // 물에 잠긴 영역 0
                } else {
                    newMap[i][j] = 1;           // 안전한 영역 1
                }
            }
        }
        return newMap;
    }
}
