package B1.BOJ11653;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 소인수분해
public class Main {
    static int N;                       // 정수
    static boolean[] primeNumber;       // false면 소수인 boolean 타입 배열
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        if (N == 1) {                   // N이 1일 경우 아무것도 출력하지 않는다.
            return;
        } else {
            primeNumber = new boolean[N + 1];
            makePrimeNumber();

            while (primeNumber[N] == true) {
                for (int i = 2; i < N; i++) {
                    if (primeNumber[i] == false && N % i == 0) {
                        list.add(i);
                        N /= i;
                        break;
                    }
                }
            }
            Collections.sort(list);
            for (int i : list) {
                bw.write(i + "\n");
            }
            bw.write(N + "\n");
            bw.flush();
        }
    }

    public static void makePrimeNumber(){
        for(int i=0; i<=N; i++){
            if(i == 0){
                primeNumber[i] = true;
            }
            if(i == 1){
                primeNumber[i] = true;
            }
            if(primeNumber[i] == false){            // 테라토스테네스의 체 구현
                for(int j=2; i*j <= N; j++){
                    primeNumber[i*j] = true;
                }
            }
        }
    }
}
