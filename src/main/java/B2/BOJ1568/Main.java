package B2.BOJ1568;

import java.io.*;

// 새
public class Main {
    static int N;           // 새의 수
    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        while(N > 0) {
            sing();
        }
        bw.write(time + "\n");
        bw.flush();
    }

    public static void sing(){
        int song = 1;
        while(N >= song){
            N -= song;
            song++;
            time++;
        }
    }
}
