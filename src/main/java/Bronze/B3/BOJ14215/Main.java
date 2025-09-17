package Bronze.B3.BOJ14215;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[3];
        for(int i=0; i<3; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int a = array[0];
        int b = array[1];
        int c = array[2];
        if(a + b > c){
            bw.write(a + b + c + "\n");
        } else {
            bw.write(a + b + a + b - 1 + "\n");
        }
        bw.flush();
    }
}
