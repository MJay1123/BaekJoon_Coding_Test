package Bronze.B5.BOJ25314;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=(size/4); i++){
            sb.append("long ");
        }
        sb.append("int");
        bw.write(sb.toString());
        bw.flush();
    }
}
