package Bronze.B3.BOJ9063;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] boundary = new int[4];
        boundary[0] = 10000;
        boundary[1] = 10000;
        boundary[2] = -10000;
        boundary[3] = -10000;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boundary[0] = Math.min(boundary[0], x);
            boundary[1] = Math.min(boundary[1], y);
            boundary[2] = Math.max(boundary[2], x);
            boundary[3] = Math.max(boundary[3], y);
        }
        bw.write((boundary[2] - boundary[0]) * (boundary[3] - boundary[1]) + "\n");
        bw.flush();
    }
}
