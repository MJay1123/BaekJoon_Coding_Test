package Bronze.B2.BOJ1592;

import java.io.*;
import java.util.StringTokenizer;
// 영식이와 친구들
public class Main {
    static int N;                   // 자리의 수
    static int M;                   // 공을 M번 받으면 끝
    static int L;                   // L번째에게 공을 전달(홀수면 시계방향, 짝수면 반시계방향)
    static int[] count;             // 공을 받은 횟수 배열
    static int passCount = -1;      // 공을 던진 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        pass(1);
        bw.write(passCount + "\n");
        bw.flush();
    }

    public static void pass(int index){
        passCount++;
        count[index]++;                 // 공을 받은 횟수 +1
        if(count[index] == M){          // M번 받았으면 종료
            return;
        }
        if(count[index] % 2 == 1){      // 홀수는 시계방향으로 전달
            index += L;
            if(index > N){
                index -= N;             // 원형 순환
            }
            pass(index);
        } else {                        // 짝수는 반시계방향으로 전달
            index -= L;
            if(index < 1){
                index += N;             // 원형 순환
            }
            pass(index);
        }
    }
}
