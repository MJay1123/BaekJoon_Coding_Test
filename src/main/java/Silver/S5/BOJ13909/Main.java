package Silver.S5.BOJ13909;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = (int)Math.sqrt(N);
        bw.write(answer + "\n");
        bw.flush();
    }
}
