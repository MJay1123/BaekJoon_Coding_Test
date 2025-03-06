package Bronze.B2.BOJ1225;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String A;
    static String B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        int sumA = 0;
        int sumB = 0;
        for(int i=0; i<A.length(); i++){
            sumA += A.charAt(i) - '0';
        }
        for(int i=0; i<B.length(); i++){
            sumB += B.charAt(i) - '0';
        }

        long answer = (long)sumA * sumB;
        bw.write(answer + "\n");
        bw.flush();
    }
}
