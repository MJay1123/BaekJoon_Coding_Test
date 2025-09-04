package Silver.S3.BOJ2579;

import java.io.*;
import java.util.Stack;

public class Main {
    static int N;       // 계단의 수
    static int[] stairs;
    static Stack<Integer> jump = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] maxCount = new int[301];
        maxCount[1] = stairs[1];
        if(N >= 2){
            maxCount[2] = stairs[1] + stairs[2];
        }
        if(N >= 3) {
            maxCount[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        }
        if(N >= 4) {
            for (int i = 4; i <= N; i++) {
                maxCount[i] = Math.max(maxCount[i - 2], maxCount[i - 3] + stairs[i - 1]) + stairs[i];
            }
        }
        System.out.println(maxCount[N]);
    }
}