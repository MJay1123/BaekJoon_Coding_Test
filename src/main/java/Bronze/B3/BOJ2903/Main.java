package Bronze.B3.BOJ2903;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int depth = 0;
        int side = 2;
        while(depth < N){
            depth++;
            side = side * 2 - 1;
        }
        int answer = side * side;
        bw.write(answer + "\n");
        bw.flush();
        /*
        * 1 3
        * 2 5
        * 3 9
        * 4 17
        * 5 33
        * */
    }
}
