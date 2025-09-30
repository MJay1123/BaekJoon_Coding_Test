package Silver.S3.BOJ2346;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        while(true){
            int number = numbers[index];
            visited[index] = true;
            sb.append(index+1 + " ");
            count++;
            if(count == N){
                break;
            }
            if(number > 0){
                for(int i=0; i<number; i++){
                    while(true){
                        index++;
                        if(index >= N){
                            index -= N;
                        }
                        if(!visited[index]){
                            break;
                        }
                    }
                }
            } else {
                for(int i=0; i<-number; i++){
                    while(true){
                        index--;
                        if(index < 0){
                            index += N;
                        }
                        if(!visited[index]){
                            break;
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
