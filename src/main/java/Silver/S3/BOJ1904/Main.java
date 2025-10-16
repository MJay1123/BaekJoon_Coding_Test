package Silver.S3.BOJ1904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N];

        arr[0][0] = 0;
        arr[1][0] = 1;
        if(N >= 2) {
            arr[0][1] = 1;
            arr[1][1] = 1;
            for (int i = 2; i < N; i++) {
                arr[0][i] = (arr[0][i - 2] + arr[1][i - 2]) % 15746;
                arr[1][i] = (arr[0][i - 1] + arr[1][i - 1]) % 15746;
            }
        }
        int answer = (arr[0][N-1] + arr[1][N-1]) % 15746;
        bw.write(answer + "\n");
        bw.flush();
    }
}
