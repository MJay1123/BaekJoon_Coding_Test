package Bronze.B5.BOJ10430;

import java.io.*;
import java.util.StringTokenizer;

// 나머지
public class Main {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int num1 = (A+B)%C;
        int num2 = ((A%C) + (B%C)) % C;
        int nmm3 = (A*B) % C;
        int num4 = ((A%C) * (B%C)) % C;

        bw.write(num1 + "\n");
        bw.write(num2 + "\n");
        bw.write(nmm3 + "\n");
        bw.write(num4 + "\n");
        bw.flush();
    }
}
