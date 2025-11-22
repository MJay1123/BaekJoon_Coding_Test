package Bronze.B1.BOJ11005;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(number, digit).toUpperCase());
        bw.flush();
    }
}
