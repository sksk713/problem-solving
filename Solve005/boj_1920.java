package Solve005;

import java.io.*;
import java.util.*;

public class boj_1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int nArr[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int mArr[] = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        for (int i = 0; i < mArr.length; i++) {
            System.out.println(solution(nArr, mArr[i]));
        }
    }

    static int solution(int[] nArr, int x) {
        if (nArr[0] > x || nArr[nArr.length - 1] < x) {
            return 0;
        }

        int first = 0;
        int mid = 0;
        int last = nArr.length - 1;

        while (first <= last) {
            mid = (first + last) / 2;
            if (nArr[mid] == x) {
                return 1;
            }
            else if (nArr[mid] < x) {
                first = mid + 1;
            }
            else if (nArr[mid] > x) {
                last = mid - 1;
            }
        }
        return 0;
    }
}
