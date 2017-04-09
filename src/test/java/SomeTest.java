import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Ignat Beresnev
 * @since 08.04.17
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SomeTest {
    private static String sequence;

    @Rule
    public final Verifier collector = new Verifier() {
        @Override
        protected void verify() {
            sequence += "verify ";
        }
    };

    public void c() {
        sequence += "test ";
    }

    @Test
    public void b() {
        sequence = "";
        c();
        assertEquals("test verify ", sequence);
    }
}
