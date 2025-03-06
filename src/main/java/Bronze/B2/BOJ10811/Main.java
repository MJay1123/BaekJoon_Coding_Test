package Bronze.B2.BOJ10811;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 바구니 뒤집기
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
        baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverse(a, b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(baskets[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }

    public static void reverse(int a, int b){
        if(a == b){
            return;
        }
        int[] temp = new int[b-a+1];
        int index = b;
        for(int i=0; i<b-a+1; i++){
            temp[i] = baskets[index];
            index--;
        }
        for(int i=a; i<=b; i++){
            baskets[i] = temp[i-a];
        }
    }
}