package Silver.S2.BOJ1780;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] count = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        if(checkNumber(paper)){
            int num = paper[0][0];
            count[num+1]++;
        } else {
            divide(paper);
        }
        bw.write(count[0] + "\n");
        bw.write(count[1] + "\n");
        bw.write(count[2] + "\n");
        bw.flush();
    }

    public static void divide(int[][] paper){
        int m = paper.length / 3;
        int[][] dividedPaper = new int[m][m];
        for(int dr=0; dr<3; dr++){
            for(int dc=0; dc<3; dc++){
                for(int r=0; r<m; r++){
                    for(int c=0; c<m; c++){
                        dividedPaper[r][c] = paper[m*dr+r][m*dc+c];
                    }
                }
                if(checkNumber(dividedPaper)){
                    int num = dividedPaper[0][0];
                    count[num+1]++;
                } else {
                    divide(dividedPaper);
                }
            }
        }
    }

    public static boolean checkNumber(int[][] paper){
        int num = paper[0][0];
        for(int r=0; r<paper.length; r++){
            for(int c=0; c<paper[0].length; c++){
                if(paper[r][c] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
