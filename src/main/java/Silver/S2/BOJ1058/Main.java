package Silver.S2.BOJ1058;

import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] connection = new int[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                if(str.charAt(j) == 'Y'){
                    connection[i][j] = 1;
                } else {
                    connection[i][j] = 1000000;
                }
            }
        }
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i == j){
                        continue;
                    }
                    connection[i][j] = Math.min(connection[i][j], connection[i][k] + connection[k][j]);
                    connection[j][i] = connection[i][j];
                }
            }
        }
        for(int i=0; i<N; i++){
            int count = 0;
            for(int j=0; j<N; j++){
                if(i == j){
                    continue;
                }
                if(connection[i][j] <= 2){
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
