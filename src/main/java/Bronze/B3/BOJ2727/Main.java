package Bronze.B3.BOJ2727;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int C = Integer.parseInt(br.readLine());
            int[] arr = new int[4];
            arr[0] = C / 25;
            C %= 25;
            arr[1] = C / 10;
            C %= 10;
            arr[2] = C / 5;
            C %= 5;
            arr[3] = C / 1;
            for(int j=0; j<4; j++){
                sb.append(arr[j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
