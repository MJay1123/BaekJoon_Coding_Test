package Bronze.B5.BOJ10952;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            String str = br.readLine();
            st = new StringTokenizer(str);
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0){
                break;
            }
            bw.write(A+B + "\n");
        }
        bw.flush();
    }
}
