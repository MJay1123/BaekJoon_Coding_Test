package Bronze.B3.BOJ1085;
// 직사각형에서의 탈출
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr = {x, y, w-x, h-y};
        int min = w;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        bw.write(min + "");
        bw.flush();
    }
}
