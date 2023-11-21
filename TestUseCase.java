//TestUseCase
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Parameterized.class)
public class TestUseCase {
    private int a;
    private int b;
    private int c;
    private String expectedOutput;

    public void TriangleTest(int a, int b, int c, String expectedOutput) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { 1, 1, 1, "Equilateral" },
                { 2, 3, 4, "Scalene" },
                { 3, 3, 5, "Isoceles" },
                // 添加更多的测试用例
        });
    }

    @Test
    public void testTriangleType() {
        assertEquals(expectedOutput, blackBoxTest.what_type_triangle2(a, b, c));
    }
}


// public class TestRunner {
//     public static void main(String[] args) {
//         Result result = JUnitCore.runClasses(TriangleTest.class);

//         for (Failure failure : result.getFailures()) {
//             System.out.println(failure.toString());
//         }

//         System.out.println(result.wasSuccessful());
//     }
// }