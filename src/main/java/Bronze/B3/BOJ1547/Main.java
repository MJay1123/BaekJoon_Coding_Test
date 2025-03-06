package Bronze.B3.BOJ1547;

import java.io.*;
import java.util.StringTokenizer;

// 공
public class Main {
    static int M;           // 컵의 위치를 바꾼 횟수
    static boolean[] cups;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        cups = new boolean[3];
        cups[0] = true;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            change(a, b);
        }
        for(int i=0; i<3; i++){
            if(cups[i]){
                bw.write(i+1 + "\n");
            }
        }
        bw.flush();
    }

    public static void change(int a, int b){
        boolean temp = cups[a];
        cups[a] = cups[b];
        cups[b] = temp;
    }
}
