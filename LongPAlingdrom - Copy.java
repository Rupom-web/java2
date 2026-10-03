
import java.util.*;
class LongestPalindrome {
static String expand(String s, int left, int right) {
while (left >= 0 && right < s.length() &&
s.charAt(left) == s.charAt(right)) {
left--;
right++;
}
return s.substring(left + 1, right);
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String s = sc.nextLine();
if (s.length() <= 1) {
System.out.println(s);
return;
}
String best = "";
for (int i = 0; i < s.length(); i++) {
String odd = expand(s, i, i);
String even = expand(s, i, i + 1);
if (odd.length() > best.length())
best = odd;
if (even.length() > best.length())
best = even;
}
System.out.println(best);
}
}