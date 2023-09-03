public class MultiCatch {
    public static void main(String[] args) {
        int myArray[] = new int[5];
        String nullString = null;

        try {
            int result = 100 / 0;
            System.out.println(myArray[10]);
            nullString.equals("JFF");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.err.println("Exception in the main method " + e.getClass().getSimpleName());
        }
    }

}
