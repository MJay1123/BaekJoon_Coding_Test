package Bronze.B2.BOJ14697;
// 방 배정하기
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());   // A,B,C 방의 정원 수(1 ~ 50)
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());   // N : 총 학생 수(1 ~ 300)

        // 빈 침대 없이 배정이 가능할 경우 표준 출력으로 1을, 불가능할 경우 0을 출력한다.

        for(int i=0; i<=N/A; i++){
            for(int j=0; j<=N/B; j++){
                for(int k=0; k<=N/C; k++){
                    if(N == A*i + B*j + C*k){
                        bw.write(1 + "");
                        bw.flush();
                        return;
                    }
                }
            }
        }
        bw.write(0 + "");
        bw.flush();
    }
}
