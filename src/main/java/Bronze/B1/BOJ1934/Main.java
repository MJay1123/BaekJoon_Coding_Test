package Bronze.B1.BOJ1934;

import java.io.*;
import java.util.StringTokenizer;
// 최소공배수
public class Main {
    static int T;
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int min = 0;
        int max = 0;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            min = Math.min(A, B);
            max = Math.max(A, B);
            while (min != 0) {
                int temp = max % min;
                max = min;
                min = temp;
            }
            bw.write(A * B / max + "\n");
        }
        bw.flush();
    }
}
