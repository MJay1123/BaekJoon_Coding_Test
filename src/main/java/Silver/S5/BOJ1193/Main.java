package Silver.S5.BOJ1193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int number = 1;
        int sum = 0;
        while(true){
            sum += number;
            if(sum > X){
                sum -= number;
                break;
            }
            number++;
        }
        if(X == sum){
            if(number % 2 == 0){
                int up = 1;
                int down = number - 1;
                bw.write(up + "/" + down + "\n");
            } else {
                int down = 1;
                int up = number - 1;
                bw.write(up + "/" + down + "\n");
            }
        } else {
            if (number % 2 == 0) {
                int up = X - sum;
                int down = number + 1 - up;
                bw.write(up + "/" + down + "\n");
            } else {
                int down = X - sum;
                int up = number + 1 - down;
                bw.write(up + "/" + down + "\n");
            }
        }
        bw.flush();
    }
}
