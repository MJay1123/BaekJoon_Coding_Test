package Silver.S3.BOJ4779;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")){
                break;
            }
            int N = Integer.parseInt(str);
            int[] array = new int[(int) Math.pow(3, N)];
            for(int i=0; i<array.length; i++){
                array[i] = 1;
            }
            cut(array, 0, array.length);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<array.length; i++){
                if(array[i] == 1){
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }

    public static void cut(int[] array, int start, int end){
        int length = end - start; // 0 1 2 [3 4 5] 6 7 8
        if(length == 1){
            return;
        }
        for(int i=start + length/3; i<start + length*2/3; i++){
            array[i] = 0;
        }
        cut(array, start, start + length/3);
        cut(array, start + length*2/3, end);
    }
}
