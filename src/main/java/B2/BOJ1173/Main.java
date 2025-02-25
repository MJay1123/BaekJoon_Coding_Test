package B2.BOJ1173;

import java.io.*;
import java.util.StringTokenizer;

// 운동
public class Main {

    static int N;       // 운동 시간
    static int m;       // 최소 맥박수
    static int M;       // 최대 맥박수
    static int T;       // 운동 시 맥박 증가량
    static int R;       // 휴식 시 맥박 감소량
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int heartbeat = m;
        int time = 0;
        int exercise = 0;
        while(true){
            if(T > M-m){
                time = -1;
                break;
            }
            if(exercise == N){
                break;
            }
            if(heartbeat + T <= M){
                time++;
                exercise++;
                heartbeat += T;
            } else {
                time++;
                heartbeat = Math.max(heartbeat - R, m);
            }
        }
        bw.write(time + "\n");
        bw.flush();
    }
}
