package Silver.S2.BOJ2805;

import java.io.*;
import java.util.StringTokenizer;

// 나무 자르기
public class Main {
    static int N;           // 나무의 수
    static int M;           // 가져갈 나무 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    }
}
