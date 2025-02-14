package B2.BOJ1100;

import java.io.*;
import java.util.Arrays;

// 하얀 칸
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] chessBoard = new String[8][8];
        for(int i=0; i<8; i++){
            String line = br.readLine();
            String[] array = line.split("");
            for(int j=0; j<8; j++){
                chessBoard[i][j] = array[j];
            }
        }

        // (0,0)은 하얀색이다. 하얀 칸 위에 말이 몇 개 있는지 구한다.

        int count = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if((i+j)%2 == 0 && chessBoard[i][j].equals("F")){
                    count++;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
    }
}
