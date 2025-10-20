package Gold.G4.BOJ1956;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[][] minimumDistance;
    static List<Integer[]>[] distanceList;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        distanceList = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            distanceList[i] = new ArrayList<>();
        }

        minimumDistance= new int[V+1][V+1];
        for(int r=1; r<=V; r++){
            for(int c=1; c<=V; c++){
                minimumDistance[r][c] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            minimumDistance[start][end] = distance;
        }
        for(int r=1; r<=V; r++){
            for(int c=1; c<=V; c++){
                for(int i=1; i<=V; i++){
                    if(minimumDistance[r][i] != Integer.MAX_VALUE && minimumDistance[i][c] != Integer.MAX_VALUE) {
                        minimumDistance[r][c] = Math.min(minimumDistance[r][c], minimumDistance[r][i] + minimumDistance[i][c]);
                    }
                }
            }
        }
        for(int i=1; i<=V; i++){
            answer = Math.min(answer, minimumDistance[i][i]);
        }
        if(answer == Integer.MAX_VALUE){
            bw.write(-1 + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
