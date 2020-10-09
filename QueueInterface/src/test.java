import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        RingBuffer k = new RingBuffer(5);
        k.enQueue(1);
        k.enQueue(2);
        k.enQueue(3);
        System.out.println(Arrays.toString(k.getArray()));
        System.out.println(k.toString());
        System.out.println(k.peek());
        System.out.println(k.last());
        System.out.println(k.getSize());
        k.deQueue();
        System.out.println(Arrays.toString(k.getArray()));
        System.out.println(k.toString());
        System.out.println(k.peek());
        System.out.println(k.last());
        System.out.println(k.getSize());
    }
}
