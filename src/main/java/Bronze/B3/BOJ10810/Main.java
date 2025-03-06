package Bronze.B3.BOJ10810;

import java.io.*;
import java.util.StringTokenizer;

// 공 넣기
public class Main {
    static int N;               // 바구니 수
    static int M;               // 공을 M번 넣는다.
    static int[] baskets;       // 바구니들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baskets = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for(int j=left; j<=right; j++){
                baskets[j] = ball;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(baskets[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
