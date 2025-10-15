package Bronze.B5.BOJ27433;

import java.io.*;

public class Main {
    static long answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        factorial(N);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void factorial(int N){
        if(N > 1){
            answer *= N;
            factorial(N-1);
        }
    }
}
