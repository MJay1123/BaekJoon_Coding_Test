package notyet.BOJ23814;

import java.io.*;
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
        StringTokenizer st;
        D = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        bw.write(K - fill() + "\n");
        bw.flush();
    }

    public static long fill(){
        long a = (D - N % D) % D;     // 추가해야 할 짜장
        long b = (D - M % D) % D;     // 추가해야 할 짬뽕
        long c = K % D;         // 이거보다 많이 빼면 군만두가 1 줄어듬
        long result = 0;
        long min = Math.min(a,b);
        long max = Math.max(a,b);
        if(min <= c){
            result += min;
            c -= min;
            if(max <= c){
                result += max;
                c -= max;
            }
        }
        return result;
    }
}
