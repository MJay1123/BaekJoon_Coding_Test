package B2.BOJ2581;

import java.io.*;

// 소수
public class Main {
    static int M;               // M이상
    static int N;               // N이하
    static boolean[] primeNumber;     // 소수(false면 소수 / true면 합성수)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        primeNumber = new boolean[N + 1];
        makePrimeNumber();
        int sum = 0;
        int min = N;
        for(int i=M; i<=N; i++){
            if(primeNumber[i] == false){
                sum += i;
                min = Math.min(min, i);
            }
        }
        if(sum == 0){
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }
        bw.flush();
    }

    public static void makePrimeNumber(){
        primeNumber[0] = true;
        primeNumber[1] = true;
        for(int i=2; i<=N; i++){
            if(!primeNumber[i]){
                for(int j=2; i*j <= N; j++){
                    primeNumber[i*j] = true;;
                }
            }
        }
    }
}
