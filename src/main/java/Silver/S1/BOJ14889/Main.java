package Silver.S1.BOJ14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 100000;
    static int[][] synergy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        synergy = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        combination(visited, 0, 0, N/2);
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void combination(boolean[] visited, int index, int depth, int r){
        if(depth == r){
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<visited.length; i++){
                for(int j=i+1; j<visited.length; j++){
                    if(visited[i] && visited[j]){
                        sum1 += synergy[i][j] + synergy[j][i];
                    } else if(!visited[i] && !visited[j]){
                        sum2 += synergy[i][j] + synergy[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(sum1 - sum2));
            return;
        }
        if(index >= visited.length){
            return;
        }
        visited[index] = true;
        combination(visited, index+1, depth+1, r);
        visited[index] = false;
        combination(visited, index+1, depth, r);
    }
}
