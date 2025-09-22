package Bronze.B1.BOJ11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 1;
        for(int i=0; i<K; i++){
            answer *= N-i;
        }
        for(int i=1; i<=K; i++){
            answer /= i;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
