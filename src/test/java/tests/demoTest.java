package tests;

import base.baseClass;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class demoTest extends baseClass {

   @Test(priority = 1, groups={"sanity"})
    public void testingName(){
       test.assignCategory("sanity");
       Assert.assertTrue(true);
   }

    @Test(priority = 2, groups={"sanity"})
    public void testingCategory(){
        test.assignCategory("sanity");
        Assert.assertTrue(true);
    }

}
