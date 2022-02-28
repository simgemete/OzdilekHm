import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage extends BaseTest {
    Logger logger = LogManager.getLogger(BasePage.class);

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        logger.info(id + "elementine tıklandı");
    }

    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("<id> li uygulamanın açıldığını kontrol et")
    public void checkOpen(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", checkText);
    }

    @Step("Alişverişe basla butonuna tıkla")
    public void ClickButton() throws InterruptedException {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).click();

    }

    @Step(" <id> li Alışveriş sayfasına gittigini kontrol et")
    public void MainOpen(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Anasayfa", checkText);
    }

    @Step("<id> li Katogoriler sayfasını aç")
    public void KategoriButton(String id) throws InterruptedException {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/nav_categories")).click();

    }



    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textIdAreacontrol(String id, String text) {
        Assertions.assertEquals("Element text değerini içermiyor", appiumDriver.findElement(By.id(id)).getText().contains(text));
        logger.info("uygulama kontrolu  -> " + text + " yapildi  ve dogrulandi.");
    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickByWithXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        logger.info("xpath li elemente tiklama basarili");
    }
    @Step("Sayfayı aşağı kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 2000;
        final int PRESS_TIME = 2000;
        int edgeBorder = 2;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2,edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
        logger.info("Sayfa scroll yapıldı");}

    @Step("Elementler <id> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomElement(String id) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.id(id));
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("Elementler arasindsan rastgele biri secildi tiklandi.");
    }
    @Step("Elementleri <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomXpathelement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("Elementler arasindsan rastgele biri secildi tiklandi.");

    }
    @Step("Seçilen Ürünü Sepete Ekleme")
    public void clickAddCartButton() throws InterruptedException {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn")).click();
    }

    }








