package Silver.S3.BOJ11726;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;           // 직사각형의 가로 길이
    static int[] result;    // 피보나치 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        result = new int[n+1];
        for(int i=1; i<=n; i++){
            if(i == 1){
                result[i] = 1;
            } else if(i==2){
                result[i] = 2;
            } else {
                result[i] = (result[i-1] + result[i-2]) % 10007;
            }
        }
        bw.write(result[n] + "\n");
        bw.flush();
    }
}
