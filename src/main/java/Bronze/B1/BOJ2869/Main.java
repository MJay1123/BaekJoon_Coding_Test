package Bronze.B1.BOJ2869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int day = (V-A) / (A-B);
        long height = (A-B) * day;
        while(true){
            day++;
            height += A;
            if(height >= V){
                break;
            }
            height -= B;
        }
        bw.write(day + "\n");
        bw.flush();
    }
}
