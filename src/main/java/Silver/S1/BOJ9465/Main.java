package Silver.S1.BOJ9465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase=0; testCase<T; testCase++){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] arr = new int[2][n];
            for(int c=0; c<n; c++){
                if(c == 0) {
                    arr[0][c] = stickers[0][c];
                    arr[1][c] = stickers[1][c];
                } else if(c == 1){
                    arr[0][c] = arr[1][c-1] + stickers[0][c];
                    arr[1][c] = arr[0][c-1] + stickers[1][c];
                } else {
                    arr[0][c] = Math.max(arr[1][c-2], arr[1][c-1]) + stickers[0][c];
                    arr[1][c] = Math.max(arr[0][c-2], arr[0][c-1]) + stickers[1][c];
                }
            }
            sb.append(Math.max(arr[0][n-1], arr[1][n-1]) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
