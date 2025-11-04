package Gold.G5.BOJ1074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int number = 0;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int length = (int)Math.pow(2, N);
        divide(length, 0, 0);
        bw.write(number + "\n");
        bw.flush();
    }
    public static void divide(int length, int nr, int nc){
        if(length == 1){
            return;
        }
        int temp = length/2;
        if(r < nr + temp && c < nc + temp){
            number += temp * temp * 0;
        }
        if(r < nr + temp && c >= nc + temp){
            number += temp * temp * 1;
            nc += temp;
        }
        if(r >= nr + temp && c < nc + temp){
            number += temp * temp * 2;
            nr += temp;
        }
        if(r >= nr + temp && c >= nc + temp) {
            number += temp * temp * 3;
            nr += temp;
            nc += temp;
        }
        divide(length/2, nr, nc);
    }
}
