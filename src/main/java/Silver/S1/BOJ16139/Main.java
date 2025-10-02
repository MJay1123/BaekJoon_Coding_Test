package Silver.S1.BOJ16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();   // 200000자 이하
        int[][] arr = new int[26][S.length()+1];
        int index = S.charAt(0) - 'a';
        arr[index][0] = 1;
        for(int i=0; i<26; i++) {
            for (int j = 0; j < S.length(); j++) {
                char ch = (char) (i + 97);
                if (S.charAt(j) == ch) {
                    arr[i][j + 1] = arr[i][j] + 1;
                } else {
                    arr[i][j + 1] = arr[i][j];
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            index = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int count = arr[index][r+1] - arr[index][l];
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
