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
    static long answer;
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
        long needN = remainN == 0 ? 0 : D - remainN;
        long needM = remainM == 0 ? 0 : D - remainM;
        answer = K - (K%D);
        K %= D;
        if(needN <= needM){
            if(needN <= K && needN != 0){
                remainN = 0;
                N += needN;
                K -= needN;
                needN = 0;
            }
            if(needM <= K){
                remainM = 0;
                M += needM;
                K -= needM;
                needM = 0;
            }
        } else {
            if(needM <= K){
                remainM = 0;
                M += needM;
                K -= needM;
                needM = 0;
            }
            if(needN <= K){
                remainN = 0;
                N += needN;
                K -= needN;
                needN = 0;
            }
        }
        answer += K;
        bw.write(answer + "\n");
        bw.flush();
    }
}