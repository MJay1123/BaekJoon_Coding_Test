package Silver.S5.BOJ1996;

import java.io.*;

// 지뢰 찾기
public class Main {
    static int N;           // N X N 정사각형
    static int[][] mine;
    static String[][] map;
    static int[][] around = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        mine = new int[N][N];
        map = new String[N][N];
        for(int i=0; i<N; i++){
            String[] array = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(array[j].equals(".")){
                    mine[i][j] = 0;
                } else {
                    mine[i][j] = Integer.parseInt(array[j]);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(mine[i][j] > 0){
                    map[i][j] = "*";
                } else {
                    map[i][j] = checkMineAround(i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static String checkMineAround(int x, int y){
        int count = 0;
        for(int i=0; i<8; i++){
            int nx = x + around[i][0];
            int ny = y + around[i][1];
            if(checkRange(nx, ny)){
                count += mine[nx][ny];
            }
        }
        if(count >= 10){
            return "M";
        } else {
            return count + "";
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
