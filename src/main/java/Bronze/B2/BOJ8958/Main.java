package Bronze.B2.BOJ8958;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<T; testCase++){
            String result = br.readLine();
            int score = 0;
            int seq = 1;
            for(int i=0; i<result.length(); i++){
                if(result.charAt(i) == 'O'){
                    score += seq;
                    seq++;
                } else {
                    seq = 1;
                }
            }
            bw.write(score + "\n");
        }
        bw.flush();
    }
}
