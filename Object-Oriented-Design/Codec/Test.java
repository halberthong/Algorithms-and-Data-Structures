import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();
        strs.add("ross"); strs.add("");
        strs.add(null); strs.add("#ww");
        strs.add("123"); strs.add("w3!ef");

        printStrings(strs);
        String coded = Codec.encode(strs);
        System.out.println(coded);
        List<String> res = Codec.decode(coded);
        printStrings(res);
    }
    private static void printStrings(List<String> list) {
        if (list == null || list.size() == 0) return;
        for (String str : list) {
            if (str == null) {
                System.out.println();
            } else {
                System.out.println(str);
            }
        }
    }
}
