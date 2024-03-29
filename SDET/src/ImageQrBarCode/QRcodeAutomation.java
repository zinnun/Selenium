package ImageQrBarCode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRcodeAutomation {

	public static void main(String[] args) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MD.ZINNUN UDDIN\\SDET\\SDET\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String QRurl= driver.findElement(By.xpath("//div[@id='HTML4']//div[@class='widget-content']//img")).getAttribute("src");
		
		URL url= new URL(QRurl);
		BufferedImage bufferedImage=ImageIO.read(url);
		
		LuminanceSource luminanceSource= new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap= new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result= new MultiFormatReader().decode(bitmap);
		result.getText();
		System.out.println(result.getText());
		
	}

}
