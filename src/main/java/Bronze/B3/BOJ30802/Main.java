package Bronze.B3.BOJ30802;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;       // 참가자의 수
    static int T;       // 티셔츠 묶음 크기
    static int P;       // 펜 묶음 크기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] tShirt = new int[6];
        for(int i=0; i<6; i++){
            tShirt[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0; i<6; i++){
            if(tShirt[i] >= 1) {
                sum += (tShirt[i] - 1) / T + 1;
            }
        }
        bw.write(sum + "\n");
        bw.write(N/P + " " + N%P);
        bw.flush();
    }
}
