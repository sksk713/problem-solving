import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static List<String> words = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        words.sort(Comparator.comparingInt(String::length));

        for (int i = 0; i < words.size(); i++) {
            boolean isPrefix = false;
            for (int j = i + 1; j < n; j++) {
                if (words.get(j).startsWith(words.get(i))) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                result++;
            }
        }

        System.out.println(result);
    }
}