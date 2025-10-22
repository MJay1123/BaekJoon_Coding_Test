package Gold.G4.BOJ10830;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        String B2 = Long.toString(B, 2);
        int[][][] result = new int[B2.length()][N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                result[0][i][j] = num;
            }
        }
        for(int b=1; b<B2.length(); b++){
            result[b] = multiply(result[b-1], result[b-1]);
        }
        answer = new int[N][N];
        for(int i=0; i<N; i++){
            answer[i][i] = 1;
        }
        for(int i=B2.length()-1; i>=0; i--){
            if(B2.charAt(i) == '1'){
                answer = multiply(answer, result[B2.length()-1-i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(answer[r][c] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int[][] multiply(int[][] arr1, int[][] arr2){
        int[][] result = new int[arr1.length][arr2[0].length];
        for(int r=0; r<result.length; r++){
            for(int c=0; c<result[0].length; c++){
                int sum = 0;
                for(int i=0; i<arr1.length; i++){
                    sum += arr1[r][i] * arr2[i][c];
                }
                result[r][c] = sum % 1000;
            }
        }
        return result;
    }
}
