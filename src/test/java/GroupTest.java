import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task2.Group;
import ua.edu.ucu.apps.task2.Signature;

import static org.junit.jupiter.api.Assertions.*;


public class GroupTest {
    @Test
    public void testSingleTaskExecution() {
        Signature<Integer> signature = new Signature<>(x -> System.out.println("Task executed: " + x));
        signature.apply(5);
        assertNotNull(signature.getId());
    }

    @Test
    public void testGroupTaskExecution() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(System.out::println))
             .addTask(new Signature<>(x -> System.out.println(x * x)));
        group.apply(3);
    }

    @Test
    public void testNestedGroupExecution() {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println))
                   .addTask(new Signature<>(x -> System.out.println(x * x)));

        Group<Integer> group = new Group<>();
        group.addTask(nestedGroup)
             .addTask(new Signature<>(x -> System.out.println(x * x * x)));

        group.apply(2);
    }

    @Test
    public void testStampingHeaders() {
        Group<Integer> group = new Group<>();
        Signature<Integer> signature1 = new Signature<>(System.out::println);
        Signature<Integer> signature2 = new Signature<>(x -> System.out.println(x * x));

        group.addTask(signature1).addTask(signature2);
        group.apply(10);

        assertNotNull(signature1.getHeader("groupId"));
        assertNotNull(signature2.getHeader("groupId"));
        assertEquals(signature1.getHeader("groupId"), signature2.getHeader("groupId"));
    }

    @Test
    public void testFrozenState() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(System.out::println));
        group.apply(7);

        assertThrows(UnsupportedOperationException.class, () -> {
            group.addTask(new Signature<>(x -> System.out.println(x * x)));
        });
    }
}