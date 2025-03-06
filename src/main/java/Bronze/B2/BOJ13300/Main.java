package Bronze.B2.BOJ13300;

import java.io.*;
import java.util.StringTokenizer;

// 방 배정
public class Main {

    static int N;               // 학생 수
    static int K;               // 방의 최대 인원
    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        // 0 : 여학생 / 1 : 남학생
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        student = new int[7][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            student[b][a] = student[b][a] + 1;
        }
        int room = 0;
        for(int i=1; i<=6; i++){
            for(int j=0; j<2; j++){
                if(student[i][j] > 0){
                    room += (student[i][j]-1)/K + 1;
                }
            }
        }
        bw.write(room + "\n");
        bw.flush();
    }
}
