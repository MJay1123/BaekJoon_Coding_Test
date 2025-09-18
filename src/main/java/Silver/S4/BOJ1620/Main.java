package Silver.S4.BOJ1620;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            hm.put(i, name);
            hm2.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(isNumber(str)){
                int num = Integer.parseInt(str);
                sb.append(hm.get(num));
                sb.append("\n");
            } else {
                sb.append(hm2.get(str));
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isNumber(String str){
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
