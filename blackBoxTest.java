// Isosceles等腰三角形
// Equilateral等边三角形
// Scalene三边不等三角形

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class blackBoxTest {
    public static void what_type_triangle(int a, int b, int c) {
        int Match = 0;
        if (a == b) {
            Match += 1;
        }
        if (a == c) {
            Match += 2;
        }
        if (b == c) {
            Match += 3;
        }
        if (Match == 0) {
            if (a + b <= c) {
                System.out.println("Not a triangle");
                return;
            }
            if (a + c <= b) {
                System.out.println("Not a triangle");
                return;
            }
            if (b + c <= a) {
                System.out.println("Not a triangle");
                return;
            }
            System.out.println("Scalene");
            return;
        } else {
            if (Match == 1) {
                if (a + b > c) {
                    System.out.println("Isosceles");
                    return;
                }
                System.out.println("Not a triangle");
                return;
            } else {
                if (Match == 2) {
                    if (a + c > b) {
                        System.out.println("Isosceles");
                        return;
                    }
                    System.out.println("Not a triangle");
                    return;
                }
                if (Match == 3) {
                    if (b + c > a) {
                        System.out.println("Isosceles");
                        return;
                    }
                    System.out.println("Not a triangle");
                    return;
                }
                System.out.println("Equilateral");
                return;
            }
        }
    }

    public static Object[] is_value_valid(int a, int b, int c) {
        Object[] result_ = new Object[2];
        List<Integer> result = new ArrayList<>();
        boolean c1 = (a >= 1 && a <= 200);
        if (c1) {
            result.add(a);
            boolean c2 = (b >= 1 && b <= 200);
            if (c2) {
                boolean c3 = (c >= 1 && c <= 200);
                result.add(b);
                if (c3) {
                    result.add(c);
                    result_[0] = result;
                    result_[1] = "all valid";
                    return result_;
                } else {
                    result_[0] = result;
                    result_[1] = "c invalid";
                    return result_;
                }
            } else {
                result_[0] = result;
                result_[1] = "b invalid";
                return result_;
            }
        } else {
            result_[0] = result;
            result_[1] = "a invalid";
            return result_;
        }
    }

    public static boolean is_triangle(int a, int b, int c) {
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        } else {
            return false;
        }
    }

    public static String what_type_triangle2(int a, int b, int c) {
        if (is_triangle(a, b, c)) {
            if (a == b && b == c) {
                return "Equilateral";
            } else {
                if (a != b && b != c && a != c) {
                    return "Scalene";
                } else {
                    return "Isosceles";
                }
            }
        } else {
            return "Not a triangle";
        }
    }

    public static int scaneInt() {
        System.out.print("请输入整数：");
        try (Scanner scan = new Scanner(System.in)) {
            int scanInt = scan.nextInt();
            return scanInt;
        }
    }

    public static List<Object[]> testData() {
        String csvFilePath = "testdata.csv";
        List<Object[]> result = new ArrayList<>();
        try (Reader reader = new FileReader(csvFilePath);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setDelimiter('\t').build())) {

            for (CSVRecord csvRecord : csvParser) {
                int a = Integer.parseInt(csvRecord.get(0));
                int b = Integer.parseInt(csvRecord.get(1));
                int c = Integer.parseInt(csvRecord.get(2));
                String expectedOutput = csvRecord.get(3);
                result.add(new Object[] { a, b, c, expectedOutput });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean myAssertEquals(String expected, String actual) {
        try {
            assertEquals(expected, actual);
            // 断言成功的逻辑
            return true;
        } catch (AssertionError e) {
            // 断言失败的处理逻辑
            return false;
        }
    }

    public static void TriangleTest(int a, int b, int c, String expectedOutput) {
        Object[] triangle_r = is_value_valid(a, b, c);
        if (triangle_r[1] == "all valid") {
            String temp = what_type_triangle2(a, b, c);
            if (!myAssertEquals(expectedOutput, temp))
                System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", 预期输出: " + expectedOutput + ", 实际输出: "
                        + temp);
        } else {
            List<Object> tempList = Arrays.asList(triangle_r[0]);
            switch (tempList.size()) {
                case 0:
                    if (!myAssertEquals(expectedOutput, (String) triangle_r[1]))
                        System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", 预期输出: " + expectedOutput
                                + ", 实际输出: " + (String) triangle_r[1]);
                    break;
                case 1:
                    if (!myAssertEquals(expectedOutput, (String) triangle_r[1]))
                        System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", 预期输出: " + expectedOutput
                                + ", 实际输出: " + (String) triangle_r[1]);
                    break;
                case 2:
                    if (!myAssertEquals(expectedOutput, (String) triangle_r[1]))
                        System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", 预期输出: " + expectedOutput
                                + ", 实际输出: " + (String) triangle_r[1]);
                    break;
                default:
                    break;
            }
            return;
        }
    }

    public static void main(String[] args) {

        List<Object[]> data = testData();
        // 遍历列表并访问每个元素的值
        for (Object[] element : data) {
            int a = (int) element[0];
            int b = (int) element[1];
            int c = (int) element[2];
            String expectedOutput = (String) element[3];
            TriangleTest(a, b, c, expectedOutput);
        }
    }
}
