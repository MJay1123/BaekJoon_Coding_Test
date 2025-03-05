package notyet.BOJ1402;

import java.io.*;
import java.util.StringTokenizer;

// 아무래도 이 문제는 A번 난이도인 것 같다.
public class Main {
    static int T;           // 테스트 케이스의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
        }

    }
//    18 = 3*6 = 2*9 = 2*3*3
//    9, 11, 8
}
