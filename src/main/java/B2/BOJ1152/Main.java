package B2.BOJ1152;

import java.io.*;
import java.util.Arrays;

// 단어의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        string = string.trim();
        String[] array = string.split(" ");
        if (array.length == 1 && array[0].equals("")) {
            bw.write(0 + "");
            bw.flush();
        } else {
            bw.write(array.length + "");
            bw.flush();
        }
    }
}
