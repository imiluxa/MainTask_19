
import Model.SlideShow;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestSlideShow {

    @Test
    public void TestPath() {
        SlideShow slideShow = new SlideShow();
        assertEquals("src\\img", slideShow.GetPathDirectory());
    }

}
