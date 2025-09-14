package Bronze.B3.BOJ5086;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 == 0 && num2 == 0){
                break;
            }
            if(num2 % num1 == 0) {
                bw.write("factor\n");
            } else if(num1 % num2 == 0){
                bw.write("multiple\n");
            } else {
                bw.write("neither\n");
            }
        }
        bw.flush();
    }
}
