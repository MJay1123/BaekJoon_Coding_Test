package Silver.S1.BOJ11403;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] connection = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                connection[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = new int[N][N];
        for(int i=0; i<N; i++){
            result = new int[N];
            DFS(connection, i, answer);
            bw.write(Arrays.toString(result));
            bw.write("\n");
        }
        bw.flush();
    }
    public static void DFS(int[][] connection, int start, int[][] answer){
        for(int i=0; i<connection.length; i++){
            if(connection[start][i] == 1 && result[i] == 0){
                answer[start][i] = 1;
                result[i] = 1;
                DFS(connection, i, answer);
            }
        }
    }
}

