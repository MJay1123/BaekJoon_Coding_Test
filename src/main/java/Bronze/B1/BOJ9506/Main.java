package Bronze.B1.BOJ9506;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == -1){
                break;
            }
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=(num/2); i++){
                if(num % i == 0){
                    sum += i;
                    list.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            if(num == sum){
                sb.append(num);
                sb.append(" = ");
                for(int i=0; i<list.size()-1; i++){
                    sb.append(list.get(i) + " + ");
                }
                sb.append(list.get(list.size()-1));
                sb.append("\n");
            } else {
                sb.append(num);
                sb.append(" is NOT perfect.\n");
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
