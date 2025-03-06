package Silver.S2.BOJ2630;

import java.io.*;
import java.util.StringTokenizer;

// 색종이 만들기
public class Main {
    static int N;
    static int whitePaper = 0;
    static int bluePaper = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        int blue = 0;
        int white = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
                if(paper[i][j] == 1){
                    blue++;
                } else {
                    white++;
                }
            }
        }

        // 하얀색 : 0 / 파란색 : 1
        if(blue == 0){
            whitePaper++;
        } else if(white == 0){
            bluePaper++;
        } else {
            divide(paper);
        }
        bw.write(whitePaper + "\n");
        bw.write(bluePaper + "\n");
        bw.flush();
    }

    public static void divide(int[][] paper){
        int length = paper.length;
        if (length == 1){
            if(paper[0][0] == 1){
                whitePaper++;
            } else {
                bluePaper++;
            }
            return;
        }
        int[][] moveIndex = {{0,0},{length/2,0},{0,length/2},{length/2,length/2}};
        for(int m=0; m<4; m++) {
            int[][] dividedPaper = new int[length/2][length/2];
            int blue = 0;
            int white = 0;
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    dividedPaper[i][j] = paper[i + moveIndex[m][0]][j + moveIndex[m][1]];
                    if (dividedPaper[i][j] == 1) {
                        blue++;
                    } else {
                        white++;
                    }
                }
            }
            if (blue == 0) {
                whitePaper++;
            } else if (white == 0) {
                bluePaper++;
            } else {
                divide(dividedPaper);
            }
        }
    }
}
