package arief.belajar.java.unit.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockingTest {

    @Test
    void testMock(){

        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("Java");
        Mockito.when(list.get(10)).thenReturn("Unit Test");

        System.out.println(list.get(0));
        System.out.println(list.get(10));

        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
