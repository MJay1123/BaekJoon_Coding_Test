package Silver.S1.BOJ1992;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int r=0; r<N; r++){
            String[] str = br.readLine().split("");
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(str[c]);
            }
        }
        if (check(arr)) {
            int num = arr[0][0];
            queue.offer(num + "");
        } else {
            divide(arr);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void divide(int[][] arr){
        int m = arr.length / 2;
        int[][] divided = new int[m][m];
        queue.offer("(");
        for(int dr=0; dr<2; dr++){
            for(int dc=0; dc<2; dc++){
                for(int r=0; r<m; r++){
                    for(int c=0; c<m; c++){
                        divided[r][c] = arr[m*dr+r][m*dc+c];
                    }
                }
                if(check(divided)){
                    int num = divided[0][0];
                    queue.offer(num + "");
                } else {
                    divide(divided);
                }
            }
        }
        queue.offer(")");
    }

    public static boolean check(int[][] arr){
        int num = arr[0][0];
        for(int r=0; r<arr.length; r++){
            for(int c=0; c<arr[0].length; c++){
                if(arr[r][c] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
