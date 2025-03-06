package Bronze.B1.BOJ1236;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 성 지키기
public class Main {
    static int N;                   // 성의 세로 크기
    static int M;                   // 성의 가로 크기
    static boolean[][] castle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        castle = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String[] array = str.split("");
            for(int j=0; j<M; j++){
                if(array[j].equals("X")){
                    castle[i][j] = true;
                }
            }
        }
        // 문제 풀이
        List<Integer> listRow = new ArrayList<>();
        List<Integer> listColumn = new ArrayList<>();
        for(int row=0; row<N; row++){
            boolean exist = false;
            for(int col=0; col<M; col++){
                if(castle[row][col] == true){
                    exist = true;
                }
            }
            if(!exist){
                listRow.add(row);
            }
        }
        for(int col=0; col<M; col++){
            boolean exist = false;
            for(int row=0; row<N; row++){
                if(castle[row][col] == true){
                    exist = true;
                }
            }
            if(!exist){
                listColumn.add(col);
            }
        }
        bw.write(Math.max(listRow.size(), listColumn.size()) + "\n");
        bw.flush();
    }
}
