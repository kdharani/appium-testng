package com.android.test.e2e;

import org.testng.Assert;
import org.testng.TestException;
import org.testng.TestNGException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngTest {

    @Test(groups = {"smoke"}, priority = 4, dependsOnMethods = "testngTest2")
    public void testngTest1(){
        System.out.println("<-------- Testng Test1 -------->");
    }
    @Parameters({"username"})
    @Test(groups = {"regression"}, enabled = true, priority = 3)
    public void testngTest2(@Optional("IamOptional")String username){
        System.out.println("<-------- Testng Test2 "+username+" -------->");

        try {
          //  Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"regression"}, enabled = false, priority = 2)
    public void testngTest3(){
        System.out.println("<-------- Testng Test3 -------->");
    }

    @Test(groups = {"smoke"}, priority = 1)
    public void testngTest4(){
        System.out.println("<-------- Testng Test4 -------->");
    }

    @Test(groups = "smoke", priority = 0)
    public void testngTest5(){
        System.out.println("<-------- Testng Test5 -------->");
    }
}
