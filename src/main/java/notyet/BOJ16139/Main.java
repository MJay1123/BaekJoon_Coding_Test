package notyet.BOJ16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();   // 200000자 이하
        char[] arr = new char[S.length()];
        for(int i=0; i<S.length(); i++){
            arr[i] = S.charAt(i);
        }
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int j=l; j<=r; j++){
                if(arr[j] == ch){
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
