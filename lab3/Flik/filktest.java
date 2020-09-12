import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class filktest {
    private int i,j;
    @Test
    public void smalltest(){
        i = 128;
        j = 128;
        //assertTrue("this should be true", Flik.isSameNumber(i,j));
        Boolean tf = Flik.isSameNumber(i,j);
    }
}
