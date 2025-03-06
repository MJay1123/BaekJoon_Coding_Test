package Bronze.B2.BOJ1233;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int S1, S2, S3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());
        S3 = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=1; i<=S1; i++){
            for(int j=1; j<=S2; j++){
                for(int k=1; k<=S3; k++){
                    int sum = i+j+k;
                    if(map.containsKey(sum)){
                        map.replace(sum, map.get(sum)+1);
                    } else {
                        map.put(sum, 1);
                    }
                }
            }
        }
        int maxKey = S1+S2+S3;
        int maxValue = 0;
        for(int i : map.keySet()){
            if(map.get(i) > maxValue){
                maxKey = i;
                maxValue = map.get(i);
            } else if(map.get(i) == maxValue && i < maxKey){
                maxKey = i;
            }
        }
        bw.write(maxKey + "\n");
        bw.flush();
    }
}
