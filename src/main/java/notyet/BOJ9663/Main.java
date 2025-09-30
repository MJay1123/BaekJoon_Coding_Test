package notyet.BOJ9663;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[][] chessBoard = new boolean[N][N];
        placeQueen(chessBoard, 0, 0, 0, N);
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void placeQueen(boolean[][] chessBoard, int r, int c, int depth, int count){
        if(depth == count){
            answer++;
            return;
        }
        if(r >= chessBoard.length || c >= chessBoard[0].length){
            return;
        }
        if(!chessBoard[r][c]){
            changeBoard(chessBoard, r, c, true);
            if(r+1 < chessBoard.length){
                placeQueen(chessBoard, r+1, c, depth+1, count);
            } else {
                placeQueen(chessBoard, 0, c+1, depth+1, count);
            }
            changeBoard(chessBoard, r, c, false);
            if(r+1 < chessBoard.length){
                placeQueen(chessBoard, r+1, c, depth, count);
            } else {
                placeQueen(chessBoard, 0, c+1, depth, count);
            }
        }
    }

    public static void changeBoard(boolean[][] chessBoard, int r, int c, boolean result){
        for(int i=0; i<chessBoard.length; i++){
            chessBoard[r][i] = result;
            chessBoard[i][c] = result;
        }
        for(int i=1; i<chessBoard.length; i++){
            if(checkRange(chessBoard, r+i, c+i)){
                chessBoard[r+i][c+i] = result;
            }
            if(checkRange(chessBoard, r+i, c-i)){
                chessBoard[r+i][c-i] = result;
            }
            if(checkRange(chessBoard, r-i, c+i)){
                chessBoard[r-i][c+i] = result;
            }
            if(checkRange(chessBoard, r-i, c-i)){
                chessBoard[r-i][c-i] = result;
            }
        }
    }

    public static boolean checkRange(boolean[][] chessBoard, int r, int c){
        return r >= 0 && r < chessBoard.length && c >= 0 && c < chessBoard[0].length;
    }
}
