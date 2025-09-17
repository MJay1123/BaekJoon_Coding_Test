package Bronze.B4.BOJ10101;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        List<Integer> angles = new ArrayList<>();
        for(int i=0; i<3; i++){
            int angle = Integer.parseInt(br.readLine());
            sum += angle;
            if(!angles.contains(angle)){
                angles.add(angle);
            }
        }
        if(sum != 180){
            bw.write("Error\n");
        } else {
            if(angles.size() == 1){
                bw.write("Equilateral\n");
            } else if(angles.size() == 2){
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
        }
        bw.flush();
    }
}
