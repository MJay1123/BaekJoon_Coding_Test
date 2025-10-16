package notyet.BOJ9663;

import java.io.*;
import java.util.Arrays;

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
            if(checkBoard(chessBoard)){
                answer++;
            }
            return;
        }
        if(r >= chessBoard.length){
            r -= chessBoard.length;
            c++;
        }
        if(c >= chessBoard[0].length){
            return;
        }
        if(!chessBoard[r][c]){
            chessBoard[r][c] = true;
            placeQueen(chessBoard, r+1, c, depth+1, count);
            chessBoard[r][c] = false;
            placeQueen(chessBoard, r+1, c, depth, count);
        }
    }

    public static boolean checkBoard(boolean[][] chessBoard){
        for(int r=0; r<chessBoard.length; r++){
            for(int c=0; c<chessBoard[0].length; c++){
                if(chessBoard[r][c]){
                    if(!checkQueen(chessBoard, r, c)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkQueen(boolean[][] chessBoard, int r, int c){
        boolean result = true;
        for(int i=0; i<chessBoard.length; i++){
            if(chessBoard[i][c] || chessBoard[r][i]){
                return false;
            }
        }
        for(int i=1; i<chessBoard.length; i++){
            if(checkRange(chessBoard, r+i, c+i) && chessBoard[r+i][c+i]){
                return false;
            }
            if(checkRange(chessBoard, r+i, c-i) && chessBoard[r+i][c-i]){
                return false;
            }
            if(checkRange(chessBoard, r-i, c+i) && chessBoard[r-i][c+i]){
                return false;
            }
            if(checkRange(chessBoard, r-i, c-i) && chessBoard[r-i][c-i]){
                return false;
            }
        }
        return true;
    }

    public static boolean checkRange(boolean[][] chessBoard, int r, int c){
        return r >= 0 && r < chessBoard.length && c >= 0 && c < chessBoard[0].length;
    }
}
