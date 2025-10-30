package Silver.S3.BOJ9375;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, List<String>> hm = new HashMap<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                if (!hm.containsKey(category)) {
                    hm.put(category, new ArrayList<String>());
                }
                hm.get(category).add(name);
            }
            int result = 1;
            for(String str : hm.keySet()){
                result *= hm.get(str).size()+1;
            }
            result--;
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
