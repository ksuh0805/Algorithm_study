/**

7
0 6 5 10 3 0 11   
-- 
5

6
100 100 100 99 97 103 
-- 
2 
 
8
0 0 0 1 2 6 8 1000
--
6
 */
package com.jungol.조커1205;

import java.util.Arrays;
import java.util.Scanner;

public class JONGOL_1205_조커3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("7\n" + "0 6 5 10 3 0 11 ");
        int N = sc.nextInt();

        int[] data = new int[N];

        // joker 카운트
        int zero = 0;
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
            if (data[i] == 0)
                zero++;
        }

        // 모든 수가 0인 경우 체크를 위해
        if (zero == N) {
            System.out.println(N);
            return;
        }

        // 정렬을 이용해서 순차적 접근
        Arrays.sort(data);

        int ans = 0;
        // 스트레이트 체크 위치를 0이 아닌 위치부터 시작
        for (int i = zero; i < N; i++) {

            // 조커 카운트를 변경하면서 사용해야 하므로 임시 변수에 조커 카운트를 담는다.
            int joker = zero;

            // 첫번째 데이터는 무조건 스트레이트에 들어가므로
            int cnt = 1;
            int prev = data[i];

            // 최초의 연속된 데이터가 아닌 위치를 찾기 위해서
            boolean first = true;

            // 현재 체크 위치 다음부터 스트레이트 확인 시작하자
            int k = i + 1;
            while (k < N) {
                int curr = data[k];
                if (prev == curr) { // 현재 위치와 이전 위치의 숫자가 같은 경우 다음 위치 이동
                    k++;
                } else if (prev + 1 == curr) { // 현재 수가 이전 수와 1 차일 경우 카운트 증가시키고 이전 수를 변경
                    prev = curr;
                    cnt++;
                    k++;
                } else { // 연속된 수가 아닌경우
                    // 연속된 수가 아닌 첫번째 케이스 인지 체크하여 이 위치를 다음 시작 위치로 지정
                    if (first) {
                        i = k - 1; // 위쪽 반복에서 i++을 하므로 여기서는 -1을 한다.
                        first = false;
                    }

                    // 만약, 조커가 없다면 더이상 진행할 수 없다.
                    if (joker == 0)
                        break;

                    prev++; // 조커를 사용하여 1을 증가
                    joker--; // 조커 카운트 감소
                    cnt++; // 연속된 수의 카운트 증가
                }
            }

            // 가장 최대인 스트레이트 숫자를 기억
            ans = Math.max(ans, cnt + joker);

            // 마지막까지 진행되었다면 더이상 진행할 필요 없음
            if (k == N)
                break;
        }
        System.out.println(ans);
    }
}