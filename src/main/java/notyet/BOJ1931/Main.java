package notyet.BOJ1931;

import java.io.*;
import java.util.StringTokenizer;

// 회의실 배정
public class Main {
    static int N;                   // 회의 수
    static int[][] meeting;         // 회의 일정
    static int firstTime = 1000000000;
    static int lastTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meeting = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            firstTime = Math.min(firstTime, meeting[i][0]);
            meeting[i][1] = Integer.parseInt(st.nextToken());
            lastTime = Math.max(lastTime, meeting[i][1]);
        }


    }

    public static void function(int time, int count){
        if(time == lastTime){
            return;
        }

    }
}
