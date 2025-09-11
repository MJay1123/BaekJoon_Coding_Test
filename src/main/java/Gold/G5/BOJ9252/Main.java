package Gold.G5.BOJ9252;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int r=1; r<dp.length; r++){
            for(int c=1; c<dp[0].length; c++){
                if(str1.charAt(r-1) == str2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
        bw.write(dp[dp.length - 1][dp[0].length - 1] + "\n");

        int row = dp.length - 1;
        int column = dp[0].length - 1;
        Stack<Character> stack = new Stack<>();
        while(true){
            if(row == 0 || column == 0){
                break;
            }
            if(str1.charAt(row-1) == str2.charAt(column-1)){
                stack.push(str1.charAt(row-1));
                row--;
                column--;
            } else {
                if(dp[row-1][column] >= dp[row][column-1]){
                    row--;
                } else {
                    column--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
