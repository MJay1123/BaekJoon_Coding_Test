package B5.BOJ2739;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=9; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
