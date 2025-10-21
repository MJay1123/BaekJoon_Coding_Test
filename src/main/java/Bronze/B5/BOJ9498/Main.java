package Bronze.B5.BOJ9498;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int score = Integer.parseInt(br.readLine());
        if(score >= 90){
            bw.write("A\n");
        } else if(score >= 80){
            bw.write("B\n");
        } else if(score >= 70){
            bw.write("C\n");
        } else if(score >= 60){
            bw.write("D\n");
        } else {
            bw.write("F\n");
        }
        bw.flush();
    }
}
