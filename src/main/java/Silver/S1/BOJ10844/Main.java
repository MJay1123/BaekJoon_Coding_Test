package Silver.S1.BOJ10844;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] count = new long[10];
        for (int i = 1; i <= 9; i++) {
            count[i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                continue;
            }
            count = dp(count);
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += count[i];
            if (sum > 1000000000) {
                sum %= 1000000000;
            }
        }
        bw.write(sum + "\n");
        bw.flush();
    }

    public static long[] dp(long[] count){
        long[] nextCount = new long[10];
        for(int i=0; i<10; i++){
            if(i==0){
                nextCount[i+1] += count[i] % 1000000000;
            } else if(i==9){
                nextCount[i-1] += count[i] % 1000000000;
            } else {
                nextCount[i-1] += count[i] % 1000000000;
                nextCount[i+1] += count[i] % 1000000000;
            }
        }
        return nextCount;
    }
}