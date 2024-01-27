/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.whatsupblasterjar;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 *
 * @author SACHIN MISHRA
 */
public class Whatsupblaster {

    public int sendImageAndMessage(String ComputerUserName, String path, List<String> phoneno, String message) {
        WebDriver driver = null;
        int sended = 0;
        try {
            WebDriverManager.edgedriver().setup();
// System.setProperty("webdriver.edge.driver", "E:\\download\\vraj\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--user-data-dir=C:\\Users\\" + ComputerUserName.trim() + "\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default", "--ignore-certificate-errors");
            System.out.println("all Arguments loaded");
            // Instantiate edge driver
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            for (int i = 0; i < phoneno.size(); i++) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Loading Whatsapp");
                driver.get("https://web.whatsapp.com/send?phone=" + phoneno.get(i) + "");
                System.out.println("Loading message");
                Dimension dimension = new Dimension(1000, 10);
//            driver.manage().window().maximize(); 
                driver.manage().window().setSize(dimension);
                TimeUnit.SECONDS.sleep(2);
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                WebElement messagebox = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"));
                File file = new File(path);
                Transferable transferableFile = new TransferableFile(file);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transferableFile, null);

                System.out.println("typed message");
                TimeUnit.MILLISECONDS.sleep(10);
                messagebox.sendKeys(Keys.CONTROL + "v");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("pasted the file");
                //click picture and paster it
                driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/span/div/span/div/div/div[2]/div/div[2]/div[2]/div/div/span")).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(2);
                messagebox.sendKeys(message);
                System.out.println("send message");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Paste the photo and send message");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().minimize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                messagebox.sendKeys(Keys.ENTER);
                TimeUnit.SECONDS.sleep(2);

                System.out.println("sendded message");
                sended++;
            }
        } catch (Exception e) {
            Logger.getLogger(Whatsupblaster.class.getName()).log(Level.SEVERE, null, e);

            e.printStackTrace();
            return sended;
        }
        // Close the browser
        driver.quit();
        return sended;
    }

    public int sendDocAndMessage(String ComputerUserName, String path, List<String> phoneno, String message) {
        WebDriver driver = null;
        int sended = 0;
        try {
            WebDriverManager.edgedriver().setup();
// System.setProperty("webdriver.edge.driver", "E:\\download\\vraj\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--user-data-dir=C:\\Users\\" + ComputerUserName.trim() + "\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default", "--ignore-certificate-errors");
            System.out.println("all Arguments loaded");
            // Instantiate edge driver
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            for (int i = 0; i < phoneno.size(); i++) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Loading Whatsapp");
                driver.get("https://web.whatsapp.com/send?phone=" + phoneno.get(i) + "");
                System.out.println("Loading message");
                Dimension dimension = new Dimension(1000, 140);
//            driver.manage().window().maximize(); 
//                driver.manage().window().setSize(dimension);
                TimeUnit.SECONDS.sleep(2);
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                WebElement messagebox = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"));
                TimeUnit.SECONDS.sleep(2);

                driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[1]/div/div/div/div/span")).click();
                TimeUnit.SECONDS.sleep(2);
//                driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[1]/div/div/span/div/ul/div/div[1]/li/div")).click();

                TimeUnit.MILLISECONDS.sleep(10);
                WebElement document = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[1]/div/div/span/div/ul/div/div[1]/li/div/input"));
                document.sendKeys(path);

                TimeUnit.SECONDS.sleep(3);

                System.out.println("pasted the file");
                //click picture and paster it
                driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/span/div/span/div/div/div[2]/div/div[2]/div[2]/div/div/span")).click();

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                TimeUnit.SECONDS.sleep(2);
//                driver.manage().window().minimize();
                messagebox.sendKeys(message);
                System.out.println("send message");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Paste the photo and send message");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                messagebox.sendKeys(Keys.ENTER);
                TimeUnit.SECONDS.sleep(2);

                System.out.println("sendded message");
                sended++;
            }
        } catch (Exception e) {
            Logger.getLogger(Whatsupblaster.class.getName()).log(Level.SEVERE, null, e);

            e.printStackTrace();
        }
        // Close the browser
        driver.quit();
        return sended;
    }

    /// only image send 
    public int sendMessage(String ComputerUserName, List<String> phoneno, String message) {
        WebDriver driver = null;
        int sended = 0;
        try {
            WebDriverManager.edgedriver().setup();
// System.setProperty("webdriver.edge.driver", "E:\\download\\vraj\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--user-data-dir=C:\\Users\\" + ComputerUserName.trim() + "\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default", "--ignore-certificate-errors");
            System.out.println("all Arguments loaded");
            // Instantiate edge driver
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            for (int i = 0; i < phoneno.size(); i++) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Loading Whatsapp");
                driver.get("https://web.whatsapp.com/send?phone=" + phoneno.get(i) + "");
                System.out.println("Loading message");
                Dimension dimension = new Dimension(1000, 10);
//            driver.manage().window().maximize(); 
                driver.manage().window().setSize(dimension);
                TimeUnit.SECONDS.sleep(2);
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                WebElement messagebox = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"));
                System.out.println("typed message");
                TimeUnit.MILLISECONDS.sleep(10);
                //click picture and paster it
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                messagebox.sendKeys(message);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(5);
                System.out.println("send message");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().minimize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                messagebox.sendKeys(Keys.ENTER);
                TimeUnit.SECONDS.sleep(2);

                System.out.println("sendded message");
                sended++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Close the browser
        driver.quit();
        return sended;
    }

    public static void main(String[] args) {
        Whatsupblaster wa = new Whatsupblaster();
        List<String> phoneNo = new ArrayList<>();
        phoneNo.add("91****************");
        phoneNo.add("91****************");
        wa.sendDocAndMessage("SACHIN MISHRA", "Z:\\git projects\\jewel\\src\\jasper_reports\\jasperpdf\\2.pdf", phoneNo, "hello teasting");
    }
}

class TransferableFile implements Transferable {

    private File file;

    public TransferableFile(File file) {
        this.file = file;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.javaFileListFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.javaFileListFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return java.util.Collections.singletonList(file);
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
