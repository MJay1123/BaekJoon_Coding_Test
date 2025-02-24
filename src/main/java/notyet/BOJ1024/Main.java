package notyet.BOJ1024;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long N;                  // 합이 N
    static int L;                   // M개 이상의 연속된 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        long count = 0;
        for(long i=L; i<=(int)Math.sqrt(N); i++){
            if(N % L == 0){
                count = L;
                break;
            }
        }


    }
}
