package Bronze.B5.BOJ9086;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            String str = br.readLine();
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length()-1));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
