package Bronze.B4.BOJ2480;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int prize = 0;
        if(a == b && b == c){
            prize = 10000 + a*1000;
        } else if(a == b || b == c){
            prize = 1000 + b*100;
        } else if(a == c){
            prize = 1000 + a*100;
        } else {
            prize = Math.max(Math.max(a, b), c) * 100;
        }
        bw.write(prize + "\n");
        bw.flush();
    }
}
