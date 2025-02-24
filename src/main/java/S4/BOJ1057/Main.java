package S4.BOJ1057;

import java.io.*;
import java.util.StringTokenizer;

// 토너먼트
public class Main {

    static int N;           // 참가자의 수
    static int K;           // 김지민
    static int L;           // 임한수
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 김지민과 임한수는 서로 대결하기 전까지 항상 이긴다
        // 김지민과 임한수가 몇 라운드에서 대결하는지 출력

        K -= 1;
        L -= 1;

        while(!(Math.abs(K-L) == 1) && K/2 == L/2){
            nextRound();
            count++;
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static void nextRound(){
        if(Math.abs(K-L) == 1 && K/2 == L/2){
            return;
        } else {
            K = K/2;
            L = L/2;
        }

    }
}
