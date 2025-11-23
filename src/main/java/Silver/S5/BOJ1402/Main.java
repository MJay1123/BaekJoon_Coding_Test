package Silver.S5.BOJ1402;

import java.io.*;
import java.util.StringTokenizer;

// 아무래도 이 문제는 A번 난이도인 것 같다.
public class Main {
    static int T;           // 테스트 케이스의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            sb.append("yes\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
//    A < B : A x 1 x 1 x 1 / B = A + 1 + 1 + 1
//    A = B : yes
//    A > B : A x -1 x -1 x 1 / B = A - 1 - 1 + 1
}
