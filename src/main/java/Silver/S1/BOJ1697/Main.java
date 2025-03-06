package Silver.S1.BOJ1697;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숨바꼭질
public class Main {
    static int N;           // 수빈
    static int K;           // 동생
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K <= N){
            bw.write(N-K + "\n");
        } else {

            int[] array = new int[K + 10];

            for (int i = 0; i < K + 10; i++) {
                array[i] = Math.abs(N - i);                                 // 1칸씩 이동할 때 걸리는 시간
            }
            for (int i = N + 1; i < K + 10; i++) {
                if (i % 2 == 0) {
                    array[i] = Math.min(array[i], array[i / 2] + 1);        // 순간이동 시간으로 대체
                }
            }
            for (int i = N + 1; i < K + 9; i++) {
                if (i % 2 == 1) {
                    array[i] = Math.min(Math.min(array[i - 1], array[i + 1]) + 1, array[i]);
                }
            }
            for(int i=N+1; i<K+9; i++){
                array[i] = Math.min(Math.min(array[i-1],array[i+1])+1, array[i]);
            }
            bw.write(array[K] + "\n");
        }
        bw.flush();
    }
}
