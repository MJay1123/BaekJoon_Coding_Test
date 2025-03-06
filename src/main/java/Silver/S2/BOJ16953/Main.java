package Silver.S2.BOJ16953;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long A;
    static long B;           // A를 연산하여 B로 만들기
    static int count;       // 연산 횟수를 받아올 인자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        count = -1;
        calculate(1);

        bw.write(count + "\n");
        bw.flush();
    }

    public static void calculate(int depth){
        if(A == B){
            count = depth;
            return;
        }
        if(A > B){
            return;
        }

        if(count > 0){
            return;
        }

        A *= 2;
        calculate(depth + 1);
        A /= 2;

        A = A * 10 + 1;
        calculate(depth + 1);
        A = (A-1)/10;
    }
}