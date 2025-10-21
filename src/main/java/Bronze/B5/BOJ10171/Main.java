package Bronze.B5.BOJ10171;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("\\    /\\\n");
        sb.append(" )  ( ')\n");
        sb.append("(  /  )\n");
        sb.append(" \\(__)|");
        bw.write(sb.toString());
        bw.flush();
    }
}
