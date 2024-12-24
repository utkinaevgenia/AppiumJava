import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void TestGetLocalNumber()
        {
            int a = this.getLocalNumber();
            Assert.assertTrue("Test failed", a == 14);
        }
    @Test
    public void TestGetClassNumber()
    {
        int a = this.getClassNumber();
        Assert.assertTrue("Test failed. class_number < 45 ", a > 45);
    }
    @Test
    public void testGetClassString()
    {
        String a = this.getClassString();
        Assert.assertTrue("Method getClassString did not return a string containing 'hello' or 'Hello'",a.contains("Hello") || a.contains("hello"));
    }
}
