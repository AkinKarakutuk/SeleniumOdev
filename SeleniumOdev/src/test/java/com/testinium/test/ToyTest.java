package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.method.Methods;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ToyTest extends BaseTest  {

     Methods methods;

    @Before
    public  void setUp(){
        methods = new Methods();
        //Login bölümü
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//button[@id='js-popup-accept-button']"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-email"),"akintestinium@gmail.com");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-password"),"123654akin");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        // new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));,
        // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();

        //methods.click(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']"));
        methods.waitBySeconds(1);
    }

    @Test
    public void toyTest(){
        //Oyuncak arama
        methods.sendKeys(By.xpath("//input[@id='search-input']"),"Oyuncak");
        methods.waitBySeconds(1);

        methods.click(By.xpath("//span[@class='common-sprite button-search']"));
        methods.waitBySeconds(1);

        //Favorilere eklemek
        methods.scrollWithAction(By.cssSelector(".search-fuzzy"));
        methods.click(By.xpath("//div[@id='product-table']/div[1]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);

        methods.scrollWithAction(By.xpath("//div[@id='product-table']/div[2]//a[5]"));
        methods.click(By.xpath("//div[@id='product-table']/div[2]//a[5]"));
        methods.waitBySeconds(1);

        methods.click(By.xpath("//div[@id='product-table']/div[3]//a[4]"));
        methods.waitBySeconds(1);

        methods.scrollWithAction(By.id("product-440988"));
        methods.click(By.xpath("//div[@id='product-table']/div[7]//a[4]"));
        methods.waitBySeconds(1);

        //Favorilerime gitmek
        methods.scrollWithAction(By.xpath("//a[.='Listelerim']"));
        methods.click(By.xpath("//div[@class='menu top my-list']//a[.='Favorilerim']"));
        methods.waitBySeconds(1);

        //Favori sayısı kontrolü
        String value = methods.getText(By.xpath("//span[.='4']"));
        Assert.assertEquals("4", value);
        methods.waitBySeconds(1);

        //Ana sayfaya gidilmesi
        methods.click(By.xpath("//div[@class='logo-text']/a[@href='https://www.kitapyurdu.com/']"));
        methods.waitBySeconds(1);

        //Puan Kataloğu açılır
        methods.click(By.xpath("//div[@class='lvl1catalog']/a[.='Puan Kataloğu']"));
        methods.waitBySeconds(1);

        //Türk klaikleri seçilir
        methods.scrollWithAction(By.id("point-carousel-view-all"));
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4359433/wh:14a4e2d16']"));
        methods.waitBySeconds(1);

        //Yüksek oylama seçimi
        methods.selectByText(By.xpath("//div[@class='sort']/select[1]"),"Yüksek Oylama");
        methods.waitBySeconds(1);

        //Tüm kitaplar>Hobi tıklanır
        methods.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[@class='has-open-menu']/span[.='Tüm Kitaplar']"));
        methods.waitBySeconds(1);

        methods.click(By.xpath("//a[.='Hobi']"));
        methods.waitBySeconds(1);

        //Sayfadan random ürün seçimi yapılır
        List<WebElement> productElems = driver.findElements(By.cssSelector(".main-box > div:nth-of-type(1) .product-grid>li"));
        // get the len of productElems
        int maxProducts = productElems.size();
        // get random number
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        // Select the list item
        productElems.get(randomProduct).click();
        methods.waitBySeconds(1);

        //Seçilen ürün sepete eklenir
        methods.click(By.xpath("//span[.='Sepete Ekle']"));
        methods.waitBySeconds(1);

        //Listelerim > favorilerim e gidilmesi
        methods.scrollWithAction(By.xpath("//a[.='Listelerim']"));
        methods.click(By.xpath("//div[@class='menu top my-list']//a[.='Favorilerim']"));
        //methods.click(By.cssSelector(".my-list li li:nth-of-type(1) > a"));
        methods.waitBySeconds(1);

        //3.Sıradaki favorilerimin silinmesi
        methods.scrollWithAction(By.xpath("//a[contains(.,'Adreslerim')]"));
        methods.click(By.xpath("//div[@class='product-list']/div[3]//div[@class='hover-menu']/a[4]"));
        methods.waitBySeconds(1);

        //Sepetime gidilir
        methods.click(By.xpath("//div[@id='cart']"));
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(1);

        //Sepedim de ürün adedinde arttırım gerçekleştirilir
        methods.click(By.xpath("//input[@name='quantity']"));
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("4");
        methods.click(By.xpath("//i[@class='fa fa-refresh green-icon']"));
        methods.waitBySeconds(1);

        //Satın al tıklanır
        methods.scrollWithAction(By.xpath("//div[@class='right']/a[contains(.,'Satın Al')]"));
        methods.click(By.xpath("//div[@class='right']/a[contains(.,'Satın Al')]"));
        methods.waitBySeconds(1);

        //Yeni adres bilgilerin kaydedilmesi
        methods.click(By.xpath("//a[.='Yeni bir adres kullanmak istiyorum.']"));
        methods.sendKeys(By.id("address-firstname-companyname"),"Akin");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-lastname-title"),"Testinium");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("address-zone-id"),"İstanbul");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("address-county-id"),"KARTAL");
        methods.waitBySeconds(1);
        //methods.selectByText(By.id("address-county-id"),"SOĞANLIK YENİ MAH");
        methods.sendKeys(By.id("district"),"SOĞANLIK YENİ MAH");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-address-text"),"Testinium");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-postcode"),"34000");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-mobile-telephone"),"5471230990");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-tax-id"),"26311663840");
        methods.waitBySeconds(1);

        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);

        //Devam et butonu
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);

        methods.scrollWithAction(By.xpath("//span[@class='ui-selectmenu-text']"));
        methods.waitBySeconds(1);

        //Kredi kartı kontrolü
        methods.sendKeys(By.id("credit-card-owner"),"Akin Testinium");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_1"),"1236");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_2"),"3909");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_3"),"8743");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_4"),"5623");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("credit-card-expire-date-month"),"03");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("credit-card-expire-date-year"),"2025");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit-card-security-code"),"167");
        methods.waitBySeconds(1);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(1);

    }

        @After
        public void tearDown(){
            methods.scrollWithAction(By.cssSelector("[alt='kitapyurdu.com']"));
            methods.waitBySeconds(1);
            methods.click(By.cssSelector("[alt='kitapyurdu.com']"));
            methods.waitBySeconds(1);
            methods.scrollWithAction(By.xpath("//a[.='Merhaba abc def']"));
            methods.waitBySeconds(1);
            methods.click(By.xpath("//a[.='Çıkış']"));
            methods.waitBySeconds(3);
        }
}
