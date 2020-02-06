public class Test {
    public static void main(String[] args){
        String str = new StringBuilder("ja").append("va").toString();
        System.out.println(str.intern() == str);
        System.gc();
    }
}
