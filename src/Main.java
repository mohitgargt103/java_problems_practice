import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://leetcode.com/problems/unique-email-addresses/
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.gcdOfStrings("ABCABC", "ABC"));

    }

    public String gcdOfStrings(String str1, String str2) {
        int a = str1.length();
        int b = str2.length();
        if (str1.equals(str2)) {
            return str1;
        }
        if (!str1.equals(str2) && a == b) {
            return "";
        }
        if (a > b) {
            if (!str1.contains(str2)) {
                return "";
            }
        } else {
            if (!str2.contains(str1)) {
                return "";
            }
        }
        int gcd = gcd(a, b);
        if (a > gcd) {
            return str1.substring(0, gcd);
        }
        return str2.substring(0, gcd);
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);

    }

}
