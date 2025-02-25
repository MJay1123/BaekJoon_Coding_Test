package notyet.BOJ1011;

import java.io.*;
import java.util.StringTokenizer;

// Fly me to the Alpha Centauri
public class Main {
    static int T;                               // 테스트 케이스 개수
    static long x;                               // 출발점
    static long y;                               // 도착점
    static long count;                           // 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            count = y-x;
            x += 1;
            jump(1, 1);
            bw.write(count+1 + "\n");
        }
        bw.flush();
    }

    public static void jump(int move, int depth){
//        System.out.println(x + " " + y + " " + depth);
        if(x == y-1){
            count = Math.min(count, depth);
            return;
        }
        if(x >= y){
            return;
        }

        if(move>1) {
            x += (move - 1);
            jump(move - 1, depth + 1);
            x -= (move - 1);
        }

        x += move;
        jump(move, depth+1);
        x -= move;

        x += (move+1);
        jump(move+1, depth+1);
        x -= (move+1);
    }
}
