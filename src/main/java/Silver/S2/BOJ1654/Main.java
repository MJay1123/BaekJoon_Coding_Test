package Silver.S2.BOJ1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lans = new int[K];
        for(int i=0; i<K; i++){
            lans[i] = Integer.parseInt(br.readLine());
        }
        long left = 0;
        long right = Integer.MAX_VALUE;
        long answer = -1;
        while(left < right){
            long middle = (left + right) / 2;
            long count = 0;
            for(int i=0; i<K; i++){
                count += lans[i] / middle;
            }
            if(count >= N){
                answer = middle;
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
