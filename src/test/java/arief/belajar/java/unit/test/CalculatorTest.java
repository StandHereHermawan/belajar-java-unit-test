package arief.belajar.java.unit.test;

import arief.belajar.java.unit.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test Untuk Calculator Class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
//    @DisplayName("Test skenario sukses untuk add(Integer, Integer)")
    public void testAddSuccess(){
        var result = calculator.add(12,13);
        assertEquals(25, result);
//        if (result != 25){
//            throw new RuntimeException("test gagal");
//        }
    }

    @Test
//    @DisplayName("Test skenario sukses untuk divide(Integer, Integer)")
    public void testDivideSuccess(){
        var result = calculator.divide(125,25);
        assertEquals(5, result);
    }

    @Test
//    @DisplayName("Test skenario gagal untuk divide(Integer, Integer)")
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class,() -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatalkan karena bukan DEV.");
        }

        // unit test untuk DEV
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
