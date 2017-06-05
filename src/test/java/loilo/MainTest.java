package loilo;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void test_3文字() {
        test("abc");
    }
    @Test
    public void test_4文字() {
        test("abcd");
    }
    @Test
    public void test_5文字() {
        test("abcde");
    }
    @Test
    public void test_6文字() {
        test("abcdef");
    }
    @Test
    public void test_10文字() {
        test("1234567890");
    }

    private static void test(String value) {
        List<String> answer = Main.makeString(value);
        checkSize(answer, value.length());
        // System.out.println(answer);
    }

    private static void checkSize(List<String> answer, int length) {
        Set<String> answerSet = new HashSet<>(answer);
        // 重複の有無をチェック
        assertEquals(answer.size(), answerSet.size());
        // 数のチェック
        assertEquals(answer.size(), 階乗(length));
    }

    private static int 階乗(int n) {
        if (n == 0) {
            return 1;
        }
        return n * 階乗(n - 1);
    }
}
