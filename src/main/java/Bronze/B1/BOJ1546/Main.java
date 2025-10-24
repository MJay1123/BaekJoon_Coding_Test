package Bronze.B1.BOJ1546;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int maxScore = 0;
        for(int i=0; i<N; i++){
            int score = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, score);
            sum += score;
        }
        bw.write(1.0 * sum / maxScore * 100 / N + "\n");
        bw.flush();
    }
}
