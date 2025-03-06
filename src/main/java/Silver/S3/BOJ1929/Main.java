package Silver.S3.BOJ1929;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소수 구하기
public class Main {
    static int M;
    static int N;
    static boolean[] primeNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        primeNumber = new boolean[1000001];
        makePrimeNumber();

        int count = 0;
        for(int i=M; i<=N; i++){
            if(!primeNumber[i]){
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }

    public static void makePrimeNumber(){
        primeNumber[0] = true;
        primeNumber[1] = true;
        for (int i = 2; i <= N; i++) {
            if (primeNumber[i] == false) {
                for (int j = i + i; j <= 1000000; j += i) {
                    primeNumber[j] = true;
                }
            }
        }
    }
}
