import org.junit.Test;
import static org.junit.Assert.*;

public class TestArithmethics {

    @Test
    public void testAdd(){
        Arithmetics a = new Arithmetics(5, 10);
        assertEquals(a.Summ(), Arithmetics.Summ(5,10));
    }

    @Test
    public void testAddHard(){
        Arithmetics a = new Arithmetics(6, 7);
        assertEquals(13, a.Summ());
    }
}
