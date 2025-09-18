package Silver.S4.BOJ10816;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numberCount = new int[20000001];
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            numberCount[number+10000000]++;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            sb.append(numberCount[number+10000000]);
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
