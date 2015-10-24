public class Test {
    public static void main(String[] args) {
        StreamingRank sr = new StreamingRank();
        sr.add("pepsi", 1000);
        sr.add("pepsi", 1000);
        sr.add("sprite", 1200);
        sr.add("bread", 2000);
        sr.printList();
    }

}
