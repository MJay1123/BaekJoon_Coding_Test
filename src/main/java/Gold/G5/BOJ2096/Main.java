package Gold.G5.BOJ2096;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                if(i == 0) {
                    dpMax[i][j] = arr[i][j];
                    dpMin[i][j] = arr[i][j];
                } else {
                    dpMax[i][j] = getMax(i, j, dpMax) + arr[i][j];
                    dpMin[i][j] = getMin(i, j, dpMin) + arr[i][j];
                }
            }
        }
        int max = dpMax[N-1][0];
        int min = dpMin[N-1][0];
        for(int i=0; i<3; i++){
            max = Math.max(max, dpMax[N-1][i]);
            min = Math.min(min, dpMin[N-1][i]);
        }
        bw.write(max + " " + min);
        bw.flush();
    }

    public static int getMax(int i, int j, int[][] dpMax){
        if(j == 0){
            return Math.max(dpMax[i-1][j], dpMax[i-1][j+1]);
        } else if(j == 2){
            return Math.max(dpMax[i-1][j], dpMax[i-1][j-1]);
        } else {
            return Math.max(Math.max(dpMax[i-1][j-1], dpMax[i-1][j]), dpMax[i-1][j+1]);
        }
    }

    public static int getMin(int i, int j, int[][] dpMin){
        if(j == 0){
            return Math.min(dpMin[i-1][j], dpMin[i-1][j+1]);
        } else if(j == 2){
            return Math.min(dpMin[i-1][j], dpMin[i-1][j-1]);
        } else {
            return Math.min(Math.min(dpMin[i-1][j-1], dpMin[i-1][j]), dpMin[i-1][j+1]);
        }
    }
}
