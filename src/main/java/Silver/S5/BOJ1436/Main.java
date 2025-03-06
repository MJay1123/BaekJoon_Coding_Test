package Silver.S5.BOJ1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

// 영화감독 숌
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int number = 100;
        int index = 0;
        while(true){
            String str = number + "";
            for(int i=0; i<str.length()-2; i++){
                if(str.charAt(i) == '6'){
                    if(str.charAt(i+1) == '6'){
                        if(str.charAt(i+2) == '6'){
                            index++;
                            break;
                        }
                    }
                }
            }
            if(index == n){
                break;
            }
            number++;
        }
        System.out.println(number);
    }
}