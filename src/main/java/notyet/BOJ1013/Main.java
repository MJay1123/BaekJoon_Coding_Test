package notyet.BOJ1013;

import java.io.*;
import java.util.Stack;

public class Main {
    static boolean isRight = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String vega = br.readLine();
            check(vega);
            bw.write((isRight ? "YES" : "NO") + "\n");
        }
        bw.flush();
    }

    public static void check(String vega) {
        if (vega.length() == 0) {
            isRight = true;
            return;
        } else if (vega.length() == 1) {
            isRight = false;
            return;
        }
        if (vega.charAt(0) == '0') {      // 01
            if (vega.charAt(1) == '0') {
                isRight = false;
                return;
            } else {
                vega = vega.substring(2);
                check(vega);
                return;
            }
        } else {                        // 100+1+
            if (vega.length() <= 3) {
                isRight = false;
                return;
            } else {
                if (vega.charAt(1) == '0' && vega.charAt(2) == '0') {
                    for (int i = 3; i < vega.length(); i++) {
                        if (vega.charAt(i) == '1') {        // 1001
                            int oneStart = i;
                            int oneEnd = i;
                            for (int j = oneStart; j < vega.length(); j++) {
                                if (vega.charAt(j) == '0') {    // 100110
                                    oneEnd = j - 1;
                                    break;
                                }
                            }
                            if (oneStart < oneEnd) { // 1001
                                if (oneEnd + 2 < vega.length() && vega.charAt(oneEnd + 1) == '0' && vega.charAt(oneEnd + 1) == '0') {
                                    vega = vega.substring(oneEnd);
                                    check(vega);
                                    return;
                                }
                            }
                            isRight = false;
                            return;
                        }
                    }
                    isRight = false;    // 10000000
                    return;
                } else {
                    isRight = false;
                    return;
                }
            }
        }
    }
}