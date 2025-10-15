package Gold.G5.BOJ2447;

import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[][] square;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        square = new boolean[N][N];
        makeSquare(0, 0, N, true);
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<square.length; r++){
            sb = new StringBuilder();
            for(int c=0; c<square[0].length; c++){
                if(square[r][c]){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }

    public static void makeSquare(int r1, int c1, int length, boolean status){
        if(length == 1){
            square[r1][c1] = status;
            return;
        }
        if(!status) {
            for (int r = r1; r < r1+length; r++) {
                for (int c = c1; c < c1+length; c++) {
                    square[r][c] = status;
                }
            }
        } else {
            int mr1 = r1 + length/3;
            int mr2 = r1 + length*2/3;
            int mc1 = c1 + length/3;
            int mc2 = c1 + length*2/3;
            makeSquare(r1, c1, length/3, true);
            makeSquare(r1, mc1, length/3, true);
            makeSquare(r1, mc2, length/3, true);
            makeSquare(mr1, c1, length/3, true);
            makeSquare(mr1, mc1, length/3, false);
            makeSquare(mr1, mc2, length/3, true);
            makeSquare(mr2, c1, length/3, true);
            makeSquare(mr2, mc1, length/3, true);
            makeSquare(mr2, mc2, length/3, true);
        }
    }
}
