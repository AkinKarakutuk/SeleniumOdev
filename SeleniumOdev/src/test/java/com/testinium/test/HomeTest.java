package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.HomePage;
import org.junit.Test;

public class HomeTest extends BaseTest {

    @Test
    public  void  homeTest(){
        HomePage homePage = new HomePage();
        homePage.home();
    }
}
