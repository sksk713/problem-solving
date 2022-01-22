package Solve010;

import java.io.*;
import java.util.*;

public class boj_14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Set<String> nList = new HashSet<>();
        List<String> mList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            nList.add(br.readLine());
        for (int j = 0; j < m; j++)
            mList.add(br.readLine());

        for (String val : mList) {
            if (nList.contains(val)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
