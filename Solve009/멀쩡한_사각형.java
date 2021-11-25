package Solve009;
import java.math.*;

class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        long answer = 1;
        BigInteger w1 = BigInteger.valueOf(w);
        BigInteger h1 = BigInteger.valueOf(h);

        BigInteger gcdNum = w1.gcd(h1);
        int newW = w / gcdNum.intValue();
        int newH = h / gcdNum.intValue();

        if (w >= h) {
            answer = ((long)w * (long)h) - (((newH - 1) * 2) + (newW - newH - 1) + 2) * gcdNum.intValue();

        }
        else {
            answer = ((long)w * (long)h) - (((newW - 1) * 2) + (newH - newW - 1) + 2) * gcdNum.intValue();
        }
        return answer;
    }
}