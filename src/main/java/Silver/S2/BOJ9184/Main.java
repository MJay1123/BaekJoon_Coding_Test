package Silver.S2.BOJ9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[][][] arr = new Integer[102][102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1){
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + fillOrUse(a,b,c) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        } else if(a > 20 || b > 20 || c > 20){
            return fillOrUse(20, 20, 20);
        } else if(a < b && b < c){
            return fillOrUse(a, b, c-1) + fillOrUse(a, b-1, c-1) - fillOrUse(a, b-1, c);
        } else {
            return fillOrUse(a-1, b, c) + fillOrUse(a-1, b-1, c) + fillOrUse(a-1, b, c-1) - fillOrUse(a-1, b-1, c-1);
        }
    }

    public static int fillOrUse(int a, int b, int c){
        if(arr[51+a][51+b][51+c] == null){
            arr[51+a][51+b][51+c] = w(a, b, c);
        }
        return arr[51+a][51+b][51+c];
    }
}
