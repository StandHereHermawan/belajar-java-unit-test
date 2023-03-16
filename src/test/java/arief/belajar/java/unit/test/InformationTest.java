package arief.belajar.java.unit.test;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class InformationTest {

    @Test
    @Tags({
            @Tag("One"),
            @Tag("Two")
    })
    @DisplayName("this is Test1")
    void test1(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null));
        System.out.println(info.getTestMethod().orElse(null));
    }
}
