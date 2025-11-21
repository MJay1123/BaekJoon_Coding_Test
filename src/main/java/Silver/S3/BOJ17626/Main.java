package Silver.S3.BOJ17626;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[50001];
        for(int i=1; i<=50000; i++){
            arr[i] = 1000000;
        }
        for(int i=1; i*i<=50000; i++){
            arr[i*i] = 1;
        }
        for(int i=1; i<=50000; i++){
            for(int j=1; i+j*j<=50000; j++){
                arr[i+j*j] = Math.min(arr[i+j*j], arr[i]+1);
            }
        }
        bw.write(arr[n] + "\n");
        bw.flush();
    }
}
