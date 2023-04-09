package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.method.Methods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public  void loginTest(){
        Methods methods = new Methods();

        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(3);

        methods.click(By.xpath("//button[@id='js-popup-accept-button']"));
        methods.waitBySeconds(3);

        methods.sendKeys(By.id("login-email"),"nese.aydin@testinium.com");
        methods.waitBySeconds(3);

        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.waitBySeconds(3);

        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        //methods.click(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']"));
        methods.waitBySeconds(3);

        //Login den sonra hesabım yazısının kontrolü
        Assert.assertTrue(methods.isElementVisible(By.xpath("//h1[@class='section']")));
        methods.waitBySeconds(3);

    }
}
