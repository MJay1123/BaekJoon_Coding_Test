package B2.BOJ10813;

import java.io.*;
import java.util.StringTokenizer;

// 공 바꾸기
public class Main {
    static int N;
    static int M;
    static int[] baskets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baskets = new int[N+1];
        for(int i=1; i<=N; i++){
            baskets[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            change(a, b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(baskets[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }

    public static void change(int a, int b){
        int temp = baskets[a];
        baskets[a] = baskets[b];
        baskets[b] = temp;
    }
}
