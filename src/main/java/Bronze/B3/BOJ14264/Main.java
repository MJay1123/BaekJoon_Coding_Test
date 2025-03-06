package Bronze.B3.BOJ14264;

import java.io.*;

// 정육각형과 삼각형
public class Main {
    static long L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        L = Integer.parseInt(br.readLine());
        double answer = L * 0.25 * L * Math.sqrt(3);
        bw.write(answer + "\n");
        bw.flush();
    }
}
