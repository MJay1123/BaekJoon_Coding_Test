package Gold.G5.BOJ5430;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            boolean error = false;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            int distance = 0;       // 0 : 정방향 / 1 : 역방향
            int left = 0;
            int right = n;
            String str = br.readLine();
            if (n > 0) {
                String[] arr = str.substring(1, str.length()-1).split(",");
                for (int i = 0; i < n; i++) {
                    list.add(Integer.parseInt(arr[i]));
                }
            }
            for(int i=0; i<p.length(); i++){
                if(p.charAt(i) == 'R'){     // R(뒤집기)
                    distance = 1 - distance;
                } else {                    // D(버리기)
                    if(left == right){
                        error = true;
                        break;
                    } else {
                        if (distance == 0) {      // 정방향
                            left++;
                        } else {                // 역방향
                            right--;
                        }
                    }
                }
            }
            if(error){
                sb.append("error\n");
            } else {
                sb.append("[");
                if (left < right) {
                    if (distance == 0) {
                        for (int i = left; i < right - 1; i++) {
                            sb.append(list.get(i) + ",");
                        }
                        sb.append(list.get(right-1) + "");
                    } else {
                        for (int i = right - 1; i > left; i--) {
                            sb.append(list.get(i) + ",");
                        }
                        sb.append(list.get(left) + "");
                    }
                }
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}