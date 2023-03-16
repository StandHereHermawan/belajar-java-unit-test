package arief.belajar.java.unit.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({
        @Tag("integration-test")
})

public class SampleIntegrationTest {

    @Test
    void name1(){
        System.out.println("FIFO");
    }

    @Test
    void name2(){
        System.out.println("LIFO");
    }

}
