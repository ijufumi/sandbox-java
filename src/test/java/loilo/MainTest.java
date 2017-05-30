package loilo;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void テスト001() {
        test("abc");
    }
    @Test
    public void テスト002() {
        test("abcd");
    }
    @Test
    public void テスト003() {
        test("abcde");
    }

    private static void test(String value) {
        List<String> answer = Main.calculate(value);
        checkSize(answer, value.length());
        System.out.println(answer);
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
