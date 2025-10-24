package notyet.BOJ23814;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 아 저는 볶음밥이요
public class Main {
    static long D;              // 군만두 서비스를 제공하는 주문 수
    static long N;              // 짜장면
    static long M;              // 짬뽕
    static long K;              // 남은 사람의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        D = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        long remainN = N % D;
        long remainM = M % D;
        long needN = D - remainN;
        long needM = D - remainM;
        long[][] answer = new long[2][2];
        answer[0][0] = K;
        answer[1][0] = K;
        long remain1 = K % D;
        long remain2 = K % D;
        if(needN <= remain1){
            answer[0][0] -= needN;
            answer[0][1]++;
            remain1 -= needN;
        }
        if(needM <= remain1){
            answer[0][0] -= needM;
            answer[0][1]++;
            remain1 -= needM;
        }
        if(needM <= remain2){
            answer[1][0] -= needM;
            answer[1][1]++;
            remain2 -= needM;
        }
        if(needN <= remain2){
            answer[1][0] -= needN;
            answer[1][1]++;
            remain2 -= needN;
        }
        if(answer[0][1] == answer[1][1]){
            bw.write(Math.max(answer[0][0], answer[1][0]) + "\n");
        } else {
            if(answer[0][1] > answer[1][1]){
                bw.write(answer[0][0] + "\n");
            } else {
                bw.write(answer[1][0] + "\n");
            }
        }
        bw.flush();
    }
}