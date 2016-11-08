import org.junit.Test;

public class Runner {

    @Test
    public void run() {

        ArraySet list = new ArraySet();
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(7);

        ArraySet list1 = new ArraySet();
        list1.add(3);
        list1.add(8);
        list1.add(9);
        list1.add(9);
        list1.add(7);

        list.addAll(list1);

        System.out.println(list.toString());


    }
}
