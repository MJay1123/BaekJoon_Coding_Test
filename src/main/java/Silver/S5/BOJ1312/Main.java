package Silver.S5.BOJ1312;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 소수
public class Main {
    static long A;
    static long B;
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int count = 0;
        while(count <= N){
            long digit = A / B;
            if(count == N){
                bw.write(digit + "\n");
                break;
            }
            A = (A%B)*10;
            count++;
        }
        bw.flush();
    }
    // 25 7 5
    // 3.571428571428


}
