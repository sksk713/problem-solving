package Solve008;

import java.util.*;

public class 전화번호_목록 {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++)
        {
            int len = phone_book[i - 1].length();
            if (phone_book[i].length() > phone_book[i - 1].length())
            {
                if (phone_book[i].substring(0, len).equals(phone_book[i - 1]))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
