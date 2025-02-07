package baekjoon.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudyStringBuilder {
    public static void main(String[] args) throws IOException {

        /* 수업목표. 코딩 알고리즘 테스트에 필요한 기본 입력 함수를 이해한다 */
        /* 수업목표. 원리는 무시한다. */

        System.out.print("문자열 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        StringBuilder sb = new StringBuilder();
        sb.append("dd ");
        sb.append("\n");
        sb.append("aaa");
        System.out.println(sb.toString());

    }
}
