package Solve005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_1039 {
    static int swap(int n, int x, int y) {

        StringBuilder nTemp = new StringBuilder(Integer.toString(n));
        char temp = nTemp.charAt(x);
        nTemp.setCharAt(x, nTemp.charAt(y));
        nTemp.setCharAt(y, temp);

        if (nTemp.charAt(0) == '0') {
            return 0;
        }
        return Integer.parseInt(nTemp.toString());
    }

    static boolean except(StringBuilder n) {
        int num = Integer.parseInt(n.toString());

        if (num < 10) {
            return true;
        }
        if (num < 100 && num % 10 == 0) {
            return true;
        }
        return false;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> nextQu = new ArrayList<>();
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder n = new StringBuilder(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (except(n)) {
            System.out.println(-1);
            return;
        }


        qu.add(Integer.parseInt(n.toString()));

        for (int i = 0; i < k; i ++) {
            while (!qu.isEmpty()) {
                int cur = qu.poll();
                for (int x = 0; x < n.length() - 1; x++) {
                    for (int y = x + 1; y < n.length(); y++) {
                        int num = swap(cur, x, y);

                        if (num == 0) {
                            continue;
                        }
                        if (!nextQu.contains(num)) {
                            nextQu.add(num);
                        }
                    }
                }
            }

            for (int j = 0; j < nextQu.size(); j++) {
                qu.add(nextQu.get(j));
            }
            nextQu.clear();
        }

        int max = Integer.MIN_VALUE;

        while (!qu.isEmpty()) {
            int cur = qu.poll();
            if (cur > max) {
                max = cur;
            }
        }

        System.out.println(max);


    }

}
