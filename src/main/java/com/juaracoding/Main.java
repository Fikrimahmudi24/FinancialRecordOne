package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 25");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium Start \n");
        delay(3);

        //Start Pengeluaran: Biaya Fikri Mahmudi
        System.out.println("Proses Pengeluaran Fikri Mahmudi :");
        MobileElement btnAdd = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnAdd.click();
        System.out.println("Add Berhasil");
        delay(2);

        MobileElement jumlah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlah.sendKeys("30000");
        System.out.println("Jumlah Berhasil");
        delay(2);

        MobileElement keterangan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keterangan.sendKeys("Uang Makan Harian");
        System.out.println("Keterangan Berhasil");
        delay(2);

        MobileElement simpan = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        simpan.click();
        System.out.println("Simpan Berhasil \n");
        delay(5);


        //Start Pemasukan: Gaji fikri mahmudi
        System.out.println("Proses Pemasukan Fikri Mahmudi :");
        MobileElement btnAddTwo = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnAddTwo.click();
        System.out.println("Add Berhasil");
        delay(2);

        MobileElement btnPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        btnPemasukan.click();
        System.out.println("Button Pengeluaran Berhasil");
        delay(2);

        MobileElement jumlahTwo = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahTwo.sendKeys("200000");
        System.out.println("Jumlah Berhasil");
        delay(2);

        MobileElement keteranganTwo = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keteranganTwo.sendKeys("Jajan Harian");
        System.out.println("Keterangan Berhasil");
        delay(2);

        MobileElement simpanTwo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        simpanTwo.click();
        System.out.println("Simpan Berhasil \n");
        delay(3);

        //Scraping
        System.out.println("Proses Scraping dan Assert :");
        MobileElement gaji = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]");
        String pemasukan = gaji.getText();
        System.out.println("Gaji= " + pemasukan);

        //Assert dengan if
        if (pemasukan.equalsIgnoreCase("200.000")) {
            System.out.println("Assert Sesuai");
        } else {
            System.out.println("Assert Tidak Sesuai");
        }
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}