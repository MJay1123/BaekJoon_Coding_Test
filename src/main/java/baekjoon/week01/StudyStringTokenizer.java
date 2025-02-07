package baekjoon.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StudyStringTokenizer {
    public static void main(String[] args) throws IOException {

        /* 설명. 단축어 설정 방법
        *   설정 - live - live Templates - 단축어 만들기 */

        /* 설명. BufferedReader + InputStreamReader로 입력값 받아서 토큰으로 삽입하기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            System.out.println(st.nextToken());
        }

        /* 설명. */
        int[] arr = new int[6];
        for(int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
