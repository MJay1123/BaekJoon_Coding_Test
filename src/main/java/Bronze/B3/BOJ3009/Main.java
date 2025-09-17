package Bronze.B3.BOJ3009;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(xMap.containsKey(x)) {
                xMap.replace(x, xMap.get(x) + 1);
            } else {
                xMap.put(x, 1);
            }
            int y = Integer.parseInt(st.nextToken());
            if(yMap.containsKey(y)){
                yMap.replace(y, yMap.get(y) + 1);
            } else {
                yMap.put(y, 1);
            }
        }
        for(int x : xMap.keySet()){
            if(xMap.get(x) == 1){
                bw.write(x + " ");
            }
        }
        for(int y : yMap.keySet()){
            if(yMap.get(y) == 1){
                bw.write(y + "\n");
            }
        }
        bw.flush();
    }
}
