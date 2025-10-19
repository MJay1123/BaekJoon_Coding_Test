package Silver.S1.BOJ1629;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String B2 = Integer.toString(B, 2);
        long[] result = new long[B2.length()];
        result[0] = A;
        for(int i=1; i<B2.length(); i++){
            result[i] = (result[i-1] * result[i-1]) % C;
        }
        long answer = 1;
        for(int i=B2.length()-1; i>=0; i--){
            if(B2.charAt(i) == '1') {
                answer *= result[B2.length() - 1 - i];
                answer %= C;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
