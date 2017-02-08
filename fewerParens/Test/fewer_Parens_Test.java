import static org.junit.Assert.*;
import org.junit.Test;


public class fewer_Parens_Test {

    @Test
    public void testExtraParens() {
        String in = "((cat))";
        String out = "(cat)";
        assertEquals(fewer_Parens.reduce(in), out);
    }

    @Test
    public void testEmptyParens() {
        String in = "()";
        String out = "";
        assertEquals(fewer_Parens.reduce(in), out);
    }

    @Test
    public void testMultipleEmptyParens() {
        String in = "(cat())()";
        String out = "(cat)";
        assertEquals(fewer_Parens.reduce(in), out);
    }

    @Test
    public void testMultipleEmptyParens2() {
        String in = "((fgh()((cat))()))";
        String out = "(fgh(cat))";
        assertEquals(fewer_Parens.reduce(in), out);
    }
}
