package Bronze.B3.BOJ2525;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        B += C;
        while(B >= 60){
            B -= 60;
            A++;
            if(A >= 24){
                A -= 24;
            }
        }
        bw.write(A + " " + B);
        bw.flush();
    }
}
