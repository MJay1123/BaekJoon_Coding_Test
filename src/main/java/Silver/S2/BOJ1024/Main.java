package Silver.S2.BOJ1024;

import java.io.*;
import java.util.StringTokenizer;
// 수열의 합
public class Main {

    static long N;                  // 합이 N
    static int L;                   // L개 이상의 연속된 수
    static boolean possible;        // 가능 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        while(true){
            int sum = getSum(L);
            if(N < sum || L > 100){
                possible = false;
                break;
            } else if((N-sum)%L == 0){
                possible = true;
                break;
            }
            L++;
        }
        if(!possible){
            bw.write(-1 + "\n");
        } else {
            StringBuilder sb = new StringBuilder();
            long start = N / L - (L-1) / 2;
            for(long i = start; i<start + L; i++){
                sb.append(i).append(" ");
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }

    public static int getSum(int n){
        return n*(n-1)/2;       // 0~(n-1)까지의 합
    }

    // 2 = 1 += 2k
    // 3 = 3 += 3k
    // 4 = 6 += 4k
    // 5 = 10 += 5k
}
