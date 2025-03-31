package Silver.S4.BOJ1205;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;               // 현재 등록된 점수의 개수
    static long newScore;
    static int P;               // 랭킹 리스트에 올라갈 수 있는 점수의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        newScore = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        long[] scores = new long[N];
        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Long.parseLong(st.nextToken());
            }
        }
        int same = 0;
        int rank = 1;
        for(int i=0; i<N; i++){
            if(newScore < scores[i]) {
                rank++;
            } else if(newScore == scores[i]) {
                same++;
            }
        }
//        System.out.println("rank = " + rank);
//        System.out.println("same = " + same);
        if(rank + same > P){
            bw.write(-1 + "\n");
        } else {
            bw.write(rank + "\n");
        }
        bw.flush();
    }
}
