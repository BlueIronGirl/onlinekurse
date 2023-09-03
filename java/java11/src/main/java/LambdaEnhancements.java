public class LambdaEnhancements {
    public static void main(String[] args) {
        AddInterface addInterface = (var a, var b) -> (a + b);
        System.out.println(addInterface.addTwoNumbers(100, 200));

        AddInterface addInterface1 = (final var a, final var b) -> (a + b);
        System.out.println(addInterface1.addTwoNumbers(100, 200));

        AddInterface addInterface2 = (final var a, final var b) -> (a + b);
        System.out.println(addInterface2.addTwoNumbers(100, 200));
    }
}

interface AddInterface {
    int addTwoNumbers(int a, int b);
}
