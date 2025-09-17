package Bronze.B3.BOJ5073;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<3; i++){
                int side = Integer.parseInt(st.nextToken());
                list.add(side);
            }
            Collections.sort(list);
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if(a == 0 && b == 0 && c == 0){
                break;
            }
            if(a + b <= c){
                bw.write("Invalid\n");
            } else {
                if (a == b && b == c) {
                    bw.write("Equilateral\n");
                } else if (a == b || b == c || a == c) {
                    bw.write("Isosceles\n");
                } else {
                    bw.write("Scalene\n");
                }
            }
        }
        bw.flush();
    }
}