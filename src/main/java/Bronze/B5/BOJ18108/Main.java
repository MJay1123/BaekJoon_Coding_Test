package Bronze.B5.BOJ18108;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int y = Integer.parseInt(br.readLine());
        bw.write(y - (2541 - 1998) + "\n");
        bw.flush();
    }
}
