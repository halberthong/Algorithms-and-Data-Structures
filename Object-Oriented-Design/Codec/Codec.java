import java.util.*;

public class Codec {
    public static String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append(0);
                sb.append('#');
            } else {
                int len = str.length();
                sb.append(len);
                sb.append('#');
                sb.append(str);
            }
        }
        return sb.toString();
    }
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (i < s.length() && s.charAt(i) != '#') {
                i++;
            }
            int len = Integer.valueOf(s.substring(j, i));
            res.add(s.substring(i + 1, i + 1 + len));
            i = i + 1 + len;
        }
        return res;
    }
}
