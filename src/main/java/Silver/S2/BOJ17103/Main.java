package Silver.S2.BOJ17103;

import java.io.*;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        boolean[] primeNumber = new boolean[1000001];
        for(int i=2; i<=1000000; i++){
            if(!primeNumber[i]){
                for(int j=2; i*j<=1000000; j++){
                    primeNumber[i*j] = true;
                }
            }
        }
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            count = 0;
            for(int i=2; i<=N/2; i++){
                if(!primeNumber[i] && !primeNumber[N-i]){
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
