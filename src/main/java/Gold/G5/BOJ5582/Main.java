package Gold.G5.BOJ5582;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        boolean[][] visited = new boolean[str1.length()+1][str2.length()+1];
        int answer = 0;
        for(int r=1; r<dp.length; r++){
            for(int c=1; c<dp[0].length; c++) {
                if(!visited[r-1][c-1]){
                    visited[r-1][c-1] = true;
                    if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                        int count = 1;
                        for (int i = 1; (r + i < dp.length && c + i < dp[0].length); i++) {
                            visited[r-1+i][c-1+i] = true;
                            if (str1.charAt(r-1+i) == str2.charAt(c-1+i)) {
                                count++;
                            } else {
                                break;
                            }
                            answer = Math.max(answer, count);
                        }
                    }
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}